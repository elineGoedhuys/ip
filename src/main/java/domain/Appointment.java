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
    
    
    private int patientId;
    private int appointmentId;
    private static int next_Id;
    private String date;
    private String hour;
    private String place;
    private int doctorId;

    
    
    public Appointment(int appointmentId,int doctorId, int patientId, String date, String hour ,String place){
        this.setPatientId(patientId);
        this.setAppointmentId(appointmentId);
        this.setDoctorId(doctorId);
        this.setPlace(place);
        this.setDate(date);
        this.setHour(hour);

    }

    public Appointment() {
       
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getHour() {
        return hour;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setDoctorId(int doctorId) {
        if(doctorId < 0){
            throw new IllegalArgumentException("Docter can't be empty.");
        }
        this.doctorId = doctorId;
    }

    public void setPatientId(int patientId) {
        if (patientId < 0){
            throw new IllegalArgumentException("Patient can't be empty.");
        }
        this.patientId = patientId;
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
        return "Appointment: "+ this.getDoctorId()+ " , "+ this.getPatientId()
                + " AppointmentId: " + this.getAppointmentId()
                + " Place: " + this.getPlace() + " Date: " + this.getDate();
    }

    public String DatabaseFormat() {
       return this.getAppointmentId() + ";" + this.getDoctorId() + ";" + this.getPatientId()
               + ";" + this.getDate() + ";" + this.getPlace() + "\n";
    }

    public void setHour(String hour) {
         this.hour = hour;
    }
              
    
}
