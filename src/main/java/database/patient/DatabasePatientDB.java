package database.patient;

import database.patient.DbException;
import domain.Address;
import domain.Patient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eline
 */
public class DatabasePatientDB implements DatabasePatient {
    
    private PreparedStatement statement;
    private Connection connection;
    
    public DatabasePatientDB(){
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
    public void create(Patient patient) {
        if(patient == null){
            throw new DbException("Nothing to add.");
        }try{
            String sql = "INSERT INTO r0365524.patient (firstname, lastname, passportid ,street, housenumber, town, zipcode, region, country, age, patientid)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getFirstname());
            statement.setString(2, patient.getLastName());
            statement.setString(3, patient.getPassportId());
            statement.setString(4, patient.getAdress().getStreet());
            statement.setString(5, patient.getAdress().getHouseNumber());
            statement.setString(6, patient.getAdress().getTown());
            statement.setString(7, patient.getAdress().getZipCode());
            statement.setString(8, patient.getAdress().getRegion());
            statement.setString(9, patient.getAdress().getCountry());
            statement.setInt(10, patient.getAge());
            statement.setInt(11, patient.getPatientId());
        }catch(SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public List<Patient> read() {
        List<Patient> list;
        list = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM r0365524.patient");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Patient patient = new Patient();
                Address address = new Address();
                patient.setFirstName(result.getString("firstname"));
                patient.setLastName(result.getString("lastname"));
                patient.setPassportId(result.getString("passportid"));
                patient.setAge(result.getInt("age"));
                address.setStreet(result.getString("street"));
                address.setHouseNumber(result.getString("housenumber"));
                address.setZipCode(result.getString("zipcode"));
                address.setTown(result.getString("town"));
                address.setRegion(result.getString("region"));
                address.setCountry(result.getString("country"));
                patient.setAdress(address);
                patient.setPatientId(result.getInt("patientid"));
                list.add(patient);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void delete(int patientid) {
        try{
            String sql = "DELETE FROM 2TX33_r0365524.patient where patientid = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, patientid);
            statement.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public void update(Patient patient) {
        this.delete(patient.getPatientId());
        this.create(patient);
    }
    
    @Override
    public int getLastId(){
        int lastId = 0;
	try{
		PreparedStatement statement = connection.prepareStatement("SELECT patientid FROM patient ORDER BY patientid DESC fetch first row only");
		ResultSet result = statement.executeQuery();
		while(result.next()){			
                lastId = Integer.parseInt(result.getString("patientid"));
		}
		}catch(SQLException e){
		throw new DbException(e);
		}
		return lastId;
	}
	
        @Override
	public int getNextId(){
		return getLastId()+1;
	}

    private void DbException(SQLException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
}
