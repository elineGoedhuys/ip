/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.patient;

import domain.Patient;
import java.util.List;

/**
 *
 * @author Eline
 */
public class DatabasePatientRepository {
    
    private DatabasePatientFactory ft = new DatabasePatientFactory();
    private DatabasePatient db = ft.DatabasePatientFactory("JPA");
    
    public DatabasePatientRepository(){
        
    }
    
    public void create(Patient patient){
        if(patient == null){
            throw new IllegalArgumentException("Nothing to create.");
        }
        db.create(patient);
    }
    
    public List<Patient> read(){
        return db.read();
    }
    
    public void update(Patient patient){
        if(patient == null){
            throw new IllegalArgumentException("Nothing to create.");
        }
        db.update(patient);
    }
    
    public void delete(long patientId){
        db.delete(patientId);
    }
    
   
    
    public Patient getPatientOnId(long patientId){
       return db.getPatientOnId(patientId);
    }
    
    public Patient getPatientOnName(String name){
        return db.getPatientOnName(name);
    }
    
    public void close(){
        db.close();
    }
}
