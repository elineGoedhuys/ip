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
        properties.setProperty("password", "r0365524");
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
        }try{
            String sql = "INSERT INTO r0365524.doctor (firstname, lastname, passportid ,street, housenumber, town, zipcode, region, country, age, doctorid)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, doctor.getFirstname());
            statement.setString(2, doctor.getLastName());
            statement.setString(3, doctor.getPassportId());
            statement.setString(4, doctor.getAdress().getStreet());
            statement.setString(5, doctor.getAdress().getHouseNumber());
            statement.setString(6, doctor.getAdress().getTown());
            statement.setString(7, doctor.getAdress().getZipCode());
            statement.setString(8, doctor.getAdress().getRegion());
            statement.setString(9, doctor.getAdress().getCountry());
            statement.setString(10, doctor.getAdress().getAge());
            statement.setInt(11, doctor.getDoctorId());
        }catch(SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public List<Doctor> read() {
         List<Doctor> list;
        list = new ArrayList<>();
        try{
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
                doctor.setAdress(address);
                doctor.setAge(result.getInt("age"));
                doctor.setDoctorId(result.getInt("doctorid"));
                list.add(doctor);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Doctor doctor) {
        this.delete(doctor.getDoctorId());
        this.create(doctor);
    }

    @Override
    public void delete(int doctroId) {
    try{
            String sql = "DELETE FROM 2TX33_r0365524.doctor where doctorid = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, doctroId);
            statement.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public int getLastId() {
        int lastId = 0;
	try{
		PreparedStatement statement = connection.prepareStatement("SELECT doctorid FROM doctor ORDER BY doctorid DESC fetch first row only");
		ResultSet result = statement.executeQuery();
		while(result.next()){			
                lastId = Integer.parseInt(result.getString("doctorid"));
		}
		}catch(SQLException e){
		throw new DbException(e);
		}
		return lastId;
    }

    @Override
    public int getNextId() {
        return getLastId()+1;
    }
    
}
