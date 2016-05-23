/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Eline
 */
@Entity
public class Patient extends Person implements Serializable {
    

    @OneToMany(mappedBy="patient", cascade=CascadeType.REMOVE)
    private Set<Appointment1> appointments;
    
    
    public Patient(long id,String firstName, String lastName,String passportId,Address address,int age){
        super(id,firstName,lastName,passportId,address,age);

    }
    
     public Patient(String firstName, String lastName, String passportId,Address address,int age){
        super(firstName,lastName,passportId,address,age);

    }


    public Set<Appointment1> getAppointments() {
        return appointments;
    }

    @JsonIgnore
    public void setAppointments(Set<Appointment1> appointments) {
        this.appointments = appointments;
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

    @Override
    @NotNull
    @NotEmpty(message = "Firstname can't be empty.")
    public String getFirstName() {
        return super.getFirstName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @NotNull
    @Min(0)
    public int getAge() {
        return super.getAge(); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    @NotNull
    @NotEmpty(message = "Lastname can't be empty.")
    public String getLastName() {
        return super.getLastName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @NotNull
    @NotEmpty(message = "PassportId can't be empty.")
    public String getPassportId() {
        return super.getPassportId(); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    
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
