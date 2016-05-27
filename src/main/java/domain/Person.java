/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author Eline
 */
@MappedSuperclass
public abstract class Person {
    
    /**@JsonIgnoreProperties**/
    @Id
    @GeneratedValue
    private long id;
 
    private String firstName;
   
    private String lastName;
    
    private String passportId;
    
    private int age;
    @OneToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinColumn(name="ADRESS_ID")
    /**@JsonManagedReference**/
    private Address address;
   
  

    public Person( long id,String firstName, String lastName, String passportId,Address address, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
        this.age = age;
        this.address = address;
   
    }

      public Person(String firstName, String lastName, String passportId,Address address,int age) {
    
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
        this.age = age;
        this.address = address;
        
    }
    
    public Person() {
    }
    
 

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }

    @JsonIgnore
    public Address getAddress() {
        return address;
    }

    @JsonIgnore
    public void setAddress(Address address) {
        this.address = address;
    }
    
    @NotNull
    @NotEmpty(message = "Street can't be empty")
    public String getStreet(){
        return address.getStreet();
    }
    
    @NotNull
    @NotEmpty(message = "HouseNumber can't be empty")
    public String getHouseNumber(){
        return address.getHouseNumber();
    }
    
    @NotNull
    @NotEmpty(message = "Zipcode can't be empty")
    public String getZipCode(){
        return address.getZipCode();
    }
    
     @NotNull
    @NotEmpty(message = "Town can't be empty")
    public String getTown(){
        return address.getTown();
    }
    
    @NotNull
    @NotEmpty(message = "Region can't be empty")
    public String getRegion(){
        return address.getRegion();
    }
    
    @NotNull
    @NotEmpty(message = "Country can't be empty")
    public String getCountry(){
        return address.getCountry();
    }
    
    
    
    
    
    

     
      public boolean equals(Person person){
        return(person.getFirstName().equals(this.firstName) && person.getLastName().equals(this.lastName)
                && person.getPassportId().equals(this.passportId) 
                && person.getAge() == this.age);
    }
    
}

   
