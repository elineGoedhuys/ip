package domain;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eline
 */
public class Appointment {
    
    private Doctor docter;
    private Patient patient;
    private int appointmentId;
    private static int next_Id;
    private Date date;
    private String place;
    private Hospital hospital;
    
    
    public Appointment(Doctor docter, Patient patient,Date date, String place, Hospital hospital){
        this.setDoctor(docter);
        this.setPatient(patient);
        this.setAppointmentId(next_Id++);
        this.setPlace(place);
        this.setDate(date);
        this.setHospital(hospital);
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Doctor getDocter() {
        return docter;
    }

    public Patient getPatient() {
        return patient;
    }

    private void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    private void setDoctor(Doctor docter) {
        if(docter == null){
            throw new IllegalArgumentException("Docter can't be empty.");
        }
        this.docter = docter;
    }

    private void setPatient(Patient patient) {
        if (patient == null){
            throw new IllegalArgumentException("Patient can't be empty.");
        }
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    private void setDate(Date date) {
        this.date = date;
    }

    private void setPlace(String place) {
        this.place = place;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Hospital getHospital() {
        return hospital;
    }
    
    public String toString(){
        return "Appointment: "+ this.getDocter().toString() + " , "+ this.getPatient().toString()
                + " AppointmentId: " + this.getAppointmentId() + " Hospital: " + this.getHospital().toString()
                + " Place: " + this.getPlace() + " Date: " + this.getDate();
    }
    
    
    
    
}
