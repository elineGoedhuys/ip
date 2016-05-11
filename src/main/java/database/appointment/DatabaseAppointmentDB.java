/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.appointment;


import domain.Address;
import domain.Appointment;
import domain.Appointment1;
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
    public void create(Appointment1 appointment) {
        if(appointment == null){
            throw new DbException("Nothing to add.");
        }try{
            String sql = "INSERT INTO r0365524.appointments (appointmentid, doctorid, patientid, date, hour, place)"
                        + "VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, appointment.getAppointmentId());
            statement.setInt(2, appointment.getDoctorId());
            statement.setInt(3, appointment.getPatientId());
            statement.setString(4, appointment.getDate());
            statement.setString(5,appointment.getUur());
            statement.setString(6, appointment.getPlace());
        }catch(SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public List<Appointment1> read() {
        List<Appointment1> list;
        list = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM r0365524.appointments");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Appointment1 app = new Appointment1();
                app.setAppointmentId(result.getInt("appointmentid"));
                app.setDoctorId(result.getInt("doctorid"));
                app.setPatientId(result.getInt("patientid"));
                app.setPlace(result.getString("place"));
                app.setDate(result.getString("date"));
                app.setUur(result.getString("hour"));
                list.add(app);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Appointment1 appointment) {
        this.delete(appointment.getAppointmentId());
        this.create(appointment);
    }

    @Override
    public void delete(long appointmentId) {
        try{
            String sql = "DELETE FROM 2TX33_r0365524.appointments where appointmentid = ?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, appointmentId);
            statement.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public Appointment1 getAppointment(long appointmentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
}
