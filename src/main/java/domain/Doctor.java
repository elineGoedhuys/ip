package domain;


import database.doctor.DatabaseDoctorFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

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
    
     @OneToMany(mappedBy="doctor", cascade=CascadeType.REMOVE)
    private Set<Appointment1> appointments;
    
   public Doctor(long id,String firstName, String lastName, String passportId,Address address , int age){
        super(id,firstName,lastName,passportId,address,age);
    }
   
   public Doctor(String firstName, String lastName, String passportId,Address address, int age){
        super(firstName,lastName,passportId,address,age);
    }
    
    public Doctor(){
        
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

    public Set<Appointment1> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment1> appointments) {
        this.appointments = appointments;
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
