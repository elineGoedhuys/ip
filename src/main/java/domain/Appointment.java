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
    
    private int docterID;
    private int patientID;
    private int appointmentId;
    private static int next_Id;
    private String date;
    private String place;

    
    
    public Appointment(int appointmentID,int docterID, int patientID,String date, String place){
        this.setDoctorID(docterID);
        this.setPatientID(patientID);
        this.setAppointmentId(appointmentID);
        this.setPlace(place);
        this.setDate(date);

    }

    public Appointment() {
       
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getDocterID() {
        return docterID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setDoctorID(int docterID) {
        if(docterID < 0){
            throw new IllegalArgumentException("Docter can't be empty.");
        }
        this.docterID = docterID;
    }

    public void setPatientID(int patientID) {
        if (patientID < 0){
            throw new IllegalArgumentException("Patient can't be empty.");
        }
        this.patientID = patientID;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    
    public String toString(){
        return "Appointment: "+ this.getDocterID()+ " , "+ this.getPatientID()
                + " AppointmentId: " + this.getAppointmentId()
                + " Place: " + this.getPlace() + " Date: " + this.getDate();
    }

    public String DatabaseFormat() {
       return this.getAppointmentId() + ";" + this.getDocterID() + ";" + this.getPatientID()
               + ";" + this.getDate() + ";" + this.getPlace() + "\n";
    }
              
    
}
