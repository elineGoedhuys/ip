/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Eline
 */
@Entity
public class Patient extends Person implements Serializable {
    
 
    
    public Patient(long id,String firstName, String lastName,String passportId,Address address,int age){
        super(id,firstName,lastName,passportId,address,age);

    }
    
     public Patient(String firstName, String lastName, String passportId,Address address,int age){
        super(firstName,lastName,passportId,address,age);

    }
   
    
    
    
    /** public Patient(long id, String firstName, String lastName, String passportId, Address address, int age){
        super(id,firstName,lastName,passportId,address,age);
    }**/
    
    /****/
    
    /**
     *
     */
    public Patient(){
        
    }



   /** public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return this.patientId;
    }**/

    
    
    /**public String toString(){
        return " Patient : " + super.toString() + " PatientID: " + this.getPatientId();
    }**/

    public String DatabaseFormat() {
     /**   return this.getFirstName() + " ; " + this.getLastName() + " ; " + this.getPassportId() +
                " ; " + this.getAddress().getStreet() + " ; " + this.getAddress().getHouseNumber() +
                " ; " + this.getAddress().getTown() + " ; " + this.getAddress().getZipCode() + 
                " ; " + this.getAddress().getRegion() + " ; " + this.getAddress().getCountry() + 
                " ; " + this.getAge() + " ; " + this.getId() + "\n";**/
     return null;
   
    }

    
}
