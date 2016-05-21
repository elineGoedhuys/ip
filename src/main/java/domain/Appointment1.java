/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Eline
 */
@Entity
public class Appointment1 implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    @NotNull
    @NotEmpty(message = "Place can't be empty.")
    private String place;
    @NotNull
    @NotEmpty(message = "Hour can't be empty.")
    private String uur;
    @NotNull
    @NotEmpty(message = "Date can't be empty.")
    private String date;

    public Appointment1() {
    }

    public Appointment1(Patient patient, Doctor doctor, String place, String uur, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.place = place;
        this.uur = uur;
        this.date = date;
    }
        

    public String getDate() {
        return date;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public String getUur() {
        return uur;
    }

    public long getId() {
        return id;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public String getPlace() {
        return place;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setUur(String uur) {
        this.uur = uur;
    }

    public boolean equals(Appointment1 app) {
        return (app.getDoctor().equals(this.getDoctor()) && (app.getPatient().equals(this.getPatient()))
                && (app.getUur().equals(this.getUur())) && (app.getPlace().equals(this.getPlace())) );
    }

    @Override
    public String toString() {
        return this.getDoctor().toString() + this.getPatient().toString() + this.getDate();
                
    }
    
    public boolean makeAgenda(Doctor doctor, String date){
        return this.getDate().equalsIgnoreCase(date) && this.getDoctor().equals(doctor);
    }
}
