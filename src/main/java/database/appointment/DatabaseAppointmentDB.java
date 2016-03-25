/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.appointment;


import domain.Address;
import domain.Appointment;
import domain.Doctor;
import domain.Patient;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Eline
 */
public class DatabaseAppointmentDB implements DatabaseAppointment{

    private PreparedStatement statement;
    private Connection connection;
    
    public DatabaseAppointmentDB(){
        String url = "jdbc:postgresql://gegevensbanken.khleuven.be:51516/2TX33";
        Properties properties = new Properties();
        properties.setProperty("user", "r0365524");
        properties.setProperty("password", "EgMdMd0110");
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, properties);
        }catch(SQLException e){
            throw new DbException(e.getMessage(),e);
        }catch (ClassNotFoundException e){
            throw new DbException(e.getMessage(),e);
        }
    }
    @Override
    public void create(Appointment appointment) {
        if(appointment == null){
            throw new DbException("Nothing to add.");
        }try{
            String sql = "INSERT INTO r0365524.appointments (appointmentid, doctorid, patientid, date, place)"
                        + "VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, appointment.getAppointmentId());
            statement.setInt(2, appointment.getDocterID());
            statement.setInt(3, appointment.getPatientID());
            statement.setString(4, appointment.getDate());
            statement.setString(5, appointment.getPlace());
        }catch(SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public List<Appointment> read() {
        List<Appointment> list;
        list = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM r0365524.appointments");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Appointment app = new Appointment();
                app.setAppointmentId(result.getInt("appointmentid"));
                app.setDoctorID(result.getInt("doctorid"));
                app.setPatientID(result.getInt("patientid"));
                app.setPlace(result.getString("place"));
                app.setDate(result.getString("date"));
                list.add(app);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Appointment appointment) {
        this.delete(appointment.getAppointmentId());
        this.create(appointment);
    }

    @Override
    public void delete(int appointmentId) {
        try{
            String sql = "DELETE FROM 2TX33_r0365524.appointments where appointmentid = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, appointmentId);
            statement.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e);
        }
    }
    
    
    
}
