/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Eline
 */
@Entity
public class Appointment1 implements Serializable {
    
    @Id
    @GeneratedValue
    private long appointmentId;
    private int doctorId;
    private int patientId;
    private String date;
    private String place;
    private String uur;
    
    
   public Appointment1(long appointmentId, int doctorId,int patientId, String date, String place,String uur){
        this.setAppointmentId(appointmentId);
        this.setDate(date);
        this.setDoctorId(doctorId);
        this.setPatientId(patientId);
        this.setPlace(place);
        this.setUur(uur);
    }
    
     public Appointment1(int doctorId, int patientId, String date, String place, String uur){
        this.setDate(date);
        this.setDoctorId(doctorId);
        this.setPatientId(patientId);
        this.setPlace(place);
        this.setUur(uur);
    }
            
    public Appointment1(){
        
    }

    public long getAppointmentId() {
        return appointmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getUur() {
        return uur;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPlace() {
        return place;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setUur(String uur) {
        this.uur = uur;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    /**public String toString(){
       return "Appointment: "+ this.getDoctorId()+ " , "+ this.getPatientId()
                + " AppointmentId: " + this.getAppointmentId()
                + " Place: " + this.getPlace() + " Date: " + this.getDate();
    }**/

    public String DatabaseFormat() {
       return this.getAppointmentId() + ";" + this.getDoctorId() + ";" + this.getPatientId()
               + ";" + this.getDate() + ";" + this.getPlace() + "\n";
    }
    
    public boolean equals(Appointment1 app){
        return this.date.equals(app.date) && this.uur.equals(app.uur) && this.doctorId == app.doctorId;
    }
    
}
