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
public class DatabaseDoctorFacade {
    
    DatabaseDoctorRepository rp = new DatabaseDoctorRepository();
    
    public void create(Doctor doctor){
        rp.create(doctor);
    }
    
    public List<Doctor> read(){
        return rp.read();
    }
    
    public void update(Doctor doctor){
        rp.update(doctor);
    }
    
    public void delete(long doctorid){
        rp.delete(doctorid);
    }
    
    public Doctor getDoctorOnId(long doctorId){
        return rp.getDoctorOnId(doctorId);
    }
    
    public Doctor getDoctorOnName(String name){
        return rp.getDoctorOnName(name);
    }
    
    public void close(){
        rp.close();
    }
}
