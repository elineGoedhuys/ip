/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Doctor;
import domain.Patient;
import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Eline
 */
public class DatabaseFacade {
    
    private DatabaseDoctorFacade df;
    private DatabasePatientFacade pf;
            
    public DatabaseFacade(){
        df = new DatabaseDoctorFacade();
        pf = new DatabasePatientFacade();
    }
    
    public List<Doctor> getDoctors(){
        return df.read();
    }
    
    public List<Patient> getPatients(){
        return pf.read();
    }
    
    public void newDoctor(Doctor doctor){
        df.create(doctor);
    }
    
    public void newPatient(Patient patient){
        pf.create(patient);
    }
    
    public void updateDoctor(Doctor doctor){
        df.update(doctor);
    }
    
    public void updatePatient(Patient patient){
        pf.update(patient);
    }
    
    public void deleteDocotor(int d){
        df.delete(d);
    }
    
    public void deletePatient(int p){
        pf.delete(p);
    }
    
    
    
    
    
    
}
