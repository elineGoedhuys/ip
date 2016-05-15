/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Eline
 */
public class Appointment1 {
    
    @Id
    @GeneratedValue
    private long id;
    private Person patient;
    private Person doctor;
    private String place;
    private String uur;
    private String date;

    public Appointment1() {
    }

    public Appointment1(Person patient, Person doctor, String place, String uur, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.place = place;
        this.uur = uur;
        this.date = date;
    }
        

    public String getDate() {
        return date;
    }

    public Person getDoctor() {
        return this.doctor;
    }

    public String getUur() {
        return uur;
    }

    public long getId() {
        return id;
    }

    public Person getPatient() {
        return this.patient;
    }

    public String getPlace() {
        return place;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDoctor(Person doctor) {
        this.doctor = doctor;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPatient(Person patient) {
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
    
    
    
           
    
}
