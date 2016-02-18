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
    
    private String patientId;
   
    public Patient(String firstName, String lastName, String passportId, Address adress, int age, String patientId){
        super(firstName,lastName,passportId,adress,age);
        this.setPatientId(patientId);
    }

    private void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }
    
    
    
    
    
    
}
