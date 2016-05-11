/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.doctor;

import domain.Address;
import domain.Doctor;
import domain.Patient;
import java.sql.Connection;
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
public class DatabaseDoctorDB implements DatabaseDoctor {

     private PreparedStatement statement;
    private Connection connection;
    
    public DatabaseDoctorDB(){
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
    public void create(Doctor doctor) {
         if(doctor == null){
            throw new DbException("Nothing to add.");
        }
         
         /**try{
            String sql = "INSERT INTO r0365524.doctor (firstname, lastname, passportid ,street, housenumber, town, zipcode, region, country, age)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, doctor.getFirstName());
            statement.setString(2, doctor.getLastName());
            statement.setString(3, doctor.getPassportId());
            statement.setString(4, doctor.getAddress().getStreet());
            statement.setString(5, doctor.getAddress().getHouseNumber());
            statement.setString(6, doctor.getAddress().getTown());
            statement.setString(7, doctor.getAddress().getZipCode());
            statement.setString(8, doctor.getAddress().getRegion());
            statement.setString(9, doctor.getAddress().getCountry());
            statement.setString(10, doctor.getAddress().getAge());
        }catch(SQLException e){
            throw new DbException(e);
        }**/
    }

    @Override
    public List<Doctor> read() {
        List<Doctor> list;
        list = new ArrayList<>();
        /**try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM r0365524.doctor");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Doctor doctor = new Doctor();
                Address address = new Address();
                doctor.setFirstName(result.getString("firstname"));
                doctor.setLastName(result.getString("lastname"));
                doctor.setPassportId(result.getString("passportid"));
                doctor.setAge(result.getInt("age"));
                address.setStreet(result.getString("street"));
                address.setHouseNumber(result.getString("housenumber"));
                address.setZipCode(result.getString("zipcode"));
                address.setTown(result.getString("town"));
                address.setRegion(result.getString("region"));
                address.setCountry(result.getString("country"));
                doctor.setAddress(address);
                doctor.setAge(result.getInt("age"));
                doctor.setId(result.getInt("doctorid"));
                list.add(doctor);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }**/
        return list;
    }

    @Override
    public void update(Doctor doctor) {
        this.delete(doctor.getId());
        this.create(doctor);
    }

    @Override
    public void delete(long doctroId) {
    try{
            String sql = "DELETE FROM 2TX33_r0365524.doctor where doctorid = ?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, doctroId);
            statement.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public Doctor getDoctorOnId(long doctorId) {
        Doctor doctor = new Doctor();
        Address address = new Address();
        /**try{
            String sql = "SELECT * from r0365524.doctor where doctorid = ? ";
            statement = connection.prepareStatement(sql);
				statement.setLong(1, doctorId);
				ResultSet result = statement.executeQuery();
				while(result.next()){
					doctor.setId(result.getInt("doctorid"));
                                        doctor.setFirstName(result.getString("firstname"));
                                        doctor.setLastName(result.getString("lastname"));
                                        doctor.setAge(result.getInt("age"));
                                        doctor.setPassportId(result.getString("passportid"));
                                        address.setCountry("country");
                                        address.setHouseNumber("housenumber");
                                        address.setRegion("region");
                                        address.setStreet("street");
                                        address.setTown("town");
                                        address.setZipCode("zipcode");
                                        doctor.setAddress(address);
				}

            
        }catch(SQLException e){
            throw new DbException(e.getMessage(), e);

        }**/
        return doctor;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
