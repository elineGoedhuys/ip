
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eline
 */
public class Hospital {
    
    private ArrayList<Docter> docters;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;
    
    public Hospital(){
        this.docters = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }
    
    public ArrayList<Docter> getDoctors(){
        return this.docters;
    }
    
    public ArrayList<Patient> getPatients(){
        return this.patients;
    }
    
    public ArrayList<Appointment> getAppointments(){
        return this.appointments;
    }
    
    public void addPatient(Patient patient){
        this.patients.add(patient);
    }
    
    public void addDocter(Docter docter){
        this.docters.add(docter);
    }
    
    public void addAppointment(Appointment app){
        this.appointments.add(app);
    }
    
    public void removePatient(Patient patient){
        this.patients.remove(patient);
    }
    
    public void removeDocter(Docter docter){
        this.docters.remove(docter);
    }
    
    public void removeAppointment(Appointment app){
        this.appointments.remove(app);
    }
    
    
    
    
}
