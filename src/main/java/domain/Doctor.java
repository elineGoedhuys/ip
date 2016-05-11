package domain;


import database.doctor.DatabaseDoctorFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eline
 */
@Entity
public class Doctor extends Person implements Serializable {
    
    
   public Doctor(long id,String firstName, String lastName, String passportId,Address address , int age){
        super(id,firstName,lastName,passportId,address,age);
    }
   
   public Doctor(String firstName, String lastName, String passportId,Address address, int age){
        super(firstName,lastName,passportId,address,age);
    }
    
    public Doctor(){
        
    }
    
    
    
    
   /** public Doctor(String lastName, String passportId, Address address, int age, int doctorId){
        super(lastName,passportId,address,age);
        this.setDoctorId(doctorId);
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDoctorId() {
        return doctorId;
    }**/
    

    
    /****/
    
  
   public String DatabaseFormat() {
       /** return this.getFirstName() + ";" + this.getLastName() + ";" + 
                this.getPassportId() + ";" + this.getAddress().getStreet() + ";" +
                this.getAddress().getHouseNumber() + ";" + this.getAddress().getTown() + ";"
                + this.getAddress().getZipCode() + ";" + this.getAddress().getRegion() + ";" +
                this.getAddress().getCountry() + ";" + this.getAge() + ";" + this.getId() + "\n";**/
       return null;
    }
}
