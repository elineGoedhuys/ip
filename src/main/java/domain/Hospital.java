package domain;


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
    
    private ArrayList<Doctor> docters;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;
    private String name;
    
    public Hospital(String name){
        this.docters = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.name = name;
    }
    
    public ArrayList<Doctor> getDoctors(){
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
    
    public void addDocter(Doctor docter){
        this.docters.add(docter);
    }
    
    public void addAppointment(Appointment app){
        this.appointments.add(app);
    }
    
    public void removePatient(Patient patient){
        this.patients.remove(patient);
    }
    
    public void removeDocter(Doctor docter){
        this.docters.remove(docter);
    }
    
    public void removeAppointment(Appointment app){
        this.appointments.remove(app);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty() || name.equals("")){
           throw new IllegalArgumentException();
        }
        this.name = name; 
    }
    
    public String stringAppointments(){
        String out = "";
        for(Appointment a : this.appointments){
            out += a.toString() + "\n";
        }
        return out;
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
    
    public String toStrin(){
        return this.getName();
    }
    
}
