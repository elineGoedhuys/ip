package domain;

import database.patient.DatabasePatientFacade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eline
 */
public class Patient extends Person{
    
    private int patientId;
    private DatabasePatientFacade db = new DatabasePatientFacade();
    
    public Patient(String firstName, String lastName, String passportId, Address adress, int age){
        super(firstName,lastName,passportId,adress,age);
        this.setPatientId(getNext_id());
    }
    public Patient(String firstName, String lastName, String passportId, Address adress, int age,int patientId){
        super(firstName,lastName,passportId,adress,age);
        this.setPatientId(patientId);
    }
    
    /**
     *
     */
    public Patient(){
        
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return this.patientId;
    }

    private int getNext_id() {
        return db.getNextId();
    }
    
    
    public String toString(){
        return " Patient : " + super.toString() + " PatientID: " + this.getPatientId();
    }

    public String DatabaseFormat() {
        return this.getFirstname() + " ; " + this.getLastName() + " ; " + this.getPassportId() +
                " ; " + this.getAdress().getStreet() + " ; " + this.getAdress().getHouseNumber() +
                " ; " + this.getAdress().getTown() + " ; " + this.getAdress().getZipCode() + 
                " ; " + this.getAdress().getRegion() + " ; " + this.getAdress().getCountry() + 
                " ; " + this.getAge() + " ; " + this.getPatientId() + "\n";
    }
    
    
    
    
    
}
