/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.doctor;

import domain.Doctor;
import java.util.List;

/**
 *
 * @author Eline
 */
public class DatabaseDoctorRepository {
    
      private DatabaseDoctorFactory ft = new DatabaseDoctorFactory();
    private DatabaseDoctor db = ft.DatabaseDoctorFactory("JPA");
    
    public DatabaseDoctorRepository(){
        
    }
    
    public void create(Doctor doctor){
        if(doctor == null){
            throw new IllegalArgumentException("Nothing to create.");
        }
        db.create(doctor);
    }
    
    public List<Doctor> read(){
        return db.read();
    }
    
    public void update(Doctor doctor){
        if(doctor == null){
            throw new IllegalArgumentException("Nothing to create.");
        }
        db.update(doctor);
    }
    
    public void delete(long doctorid){
        db.delete(doctorid);
    }
    
    public Doctor getDoctorOnId(long doctorId){
        return db.getDoctorOnId(doctorId);
    
    }
    
    public Doctor getDoctorOnName(String name){
        return db.getDoctorOnName(name);
    }
    
    public void close(){
        db.close();
    }
}
