/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Eline
 */
public class Agenda {
    
    private String date;
    private Doctor doctor;

    public String getDate() {
        return date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
