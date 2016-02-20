/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Patient;
import java.util.List;

/**
 *
 * @author Eline
 */
public class DatabasePatientFacade {
    
    DatabasePatientRepository rp = new DatabasePatientRepository();
    
    public void create(Patient patient){
        rp.create(patient);
    }
    
    public List<Patient> read(){
        return rp.read();
    }
    
    public void update(Patient patient){
        rp.update(patient);
    }
    
    public void delete(int patientid){
        rp.delete(patientid);
    }
    
    public int getNextId(){
        return rp.getNextId();
    }
}
