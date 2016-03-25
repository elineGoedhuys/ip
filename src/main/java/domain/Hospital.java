package domain;


import service.DatabaseFacade;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eline
 * Deze klasse wordt niet meer gebruikt
 */
public class Hospital {
    
    private List<Doctor> docters;
    private List<Patient> patients;
    DatabaseFacade db = new DatabaseFacade();
    
    
    public Hospital(){
        this.docters = db.getDoctors();
        this.patients = db.getPatients();
    }
    
    public ArrayList<Doctor> getDoctors(){
        return (ArrayList<Doctor>) db.getDoctors();
    }
    
    public ArrayList<Patient> getPatients(){
        return (ArrayList<Patient>) db.getPatients();
    }
    
    public void addPatient(Patient patient){
        db.newPatient(patient);
    }
    
    public void addDocter(Doctor docter){
        db.newDoctor(docter);
    }
    
    public void removePatient(int patientid){
        db.deletePatient(patientid);
    }
    
    public void removeDocter(int doctorid){
        db.deleteDocotor(doctorid);
    }

    public void updateDoctor(Doctor doctor){
        db.updateDoctor(doctor);
    }
    
    public void updatePatient(Patient patient){
        db.updatePatient(patient);
    }
    
     public String stringDocters(){
        String out = "";
        for(Doctor d : this.docters){
            out += d.toString() + "\n";
        }
        return out;
    }
     
    public String stringPatients(){
        String out = "";
        for(Patient p : this.patients){
            out += p.toString() + "\n";
        }
        return out;
    }
   
    
}
