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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NotNull
    @NotEmpty(message = "Firstname can't be empty.")
    private String firstName;
    @NotNull
    @NotEmpty(message = "Lastname can't be empty.")
    private String lastName;
    @NotNull
    @NotEmpty(message = "PassportId can't be empty.")
    private String passportId;
    @NotNull
    @Min(0)
    private int age;
    @OneToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinColumn(name="ADRESS_ID")
    /**@JsonManagedReference**/
    @NotNull
    @NotEmpty
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

    public void setAddress(Address address) {
        this.address = address;
    }

 
    
    
    
            
            
      public boolean equals(Person person){
        return(person.getFirstName().equals(this.firstName) && person.getLastName().equals(this.lastName)
                && person.getPassportId().equals(this.passportId) 
                && person.getAge() == this.age);
    }
    
    /**public String toString(){
        return "Firstname: " + this.getFirstName() + " Lastname: " + this.getLastName() +
                " PassportId: " + this.getPassportId() + " Age: "+this.getAge() 
                + " Address: " +this.getAddress().toString();
    }**/
    
}

   
