package domain;


import database.doctor.DatabaseDoctorFacade;
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
public class Doctor extends Person {
    
    private int doctorId;
    private DatabaseDoctorFacade db = new DatabaseDoctorFacade();
    
    public Doctor(){
        
    }
    
     public Doctor(String firstName, String lastName, String passportId, Address address, int age){
        super(firstName,lastName,passportId,address,age);
        this.setDoctorId(getNextId());
    }
    
    public Doctor(String firstName, String lastName, String passportId, Address address, int age, int doctorId){
        super(firstName,lastName,passportId,address,age);
        this.setDoctorId(doctorId);
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDoctorId() {
        return doctorId;
    }
    
    private int getNextId(){
        return db.getNextId();
    }

    
    public String toString(){
        return "Doctor: " + super.toString() + " DoctorId: " + this.getDoctorId();
    }
    
  
    public String DatabaseFormat() {
        return this.getFirstname() + ";" + this.getLastName() + ";" + 
                this.getPassportId() + ";" + this.getAdress().getStreet() + ";" +
                this.getAdress().getHouseNumber() + ";" + this.getAdress().getTown() + ";"
                + this.getAdress().getZipCode() + ";" + this.getAdress().getRegion() + ";" +
                this.getAdress().getCountry() + ";" + this.getDoctorId() + "\n";
    }
}
