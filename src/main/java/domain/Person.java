package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eline
 */
public abstract class Person {
    
    private String firstName;
    private String lastName;
    private String passportId;
    private Address adress;
    private int age;
    
    
    public Person(String firstname,String lastname,String passportId,Address adress,int age){
        if(firstname.equals("") || lastname.equals("") || passportId.equals("") || adress == null ||
                age < 0){
            throw new IllegalArgumentException("");
        }
        this.firstName = firstname;
        this.lastName = lastname;
        this.passportId = passportId;
        this.adress = adress;
        this.age = age;
    }
    
    public Person(){
        
    }

    public void setFirstName(String firstname){
       if (firstName.isEmpty()){
          throw new IllegalArgumentException("Firstname can't be empty");
       }
       this.firstName = firstname;
    }

    public void setLastName(String lastname) {
        if (lastName.isEmpty()){
            throw new IllegalArgumentException("Lastname can't be empty");
        }
        this.lastName = lastname;
    }

    public void setPassportId(String passportId) {
      if (passportId.isEmpty()){
          throw new IllegalArgumentException("passportId can't be empty");
      }
      this.passportId = passportId;
    }

    public void setAdress(Address adress) {
       if (adress == null){
           throw new IllegalArgumentException();
       }
       this.adress = adress;
    }

    public void setAge(int age) {
        if(age < 0 ){
            throw new IllegalArgumentException("age can't be under 0.");
        }
        this.age = age;
    }
    
    public String getFirstname(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getPassportId(){
        return this.passportId;
    }
    
    public Address getAdress(){
        return this.adress;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public boolean equals(Person person){
        return(person.getFirstname().equals(this.firstName) && person.getLastName().equals(this.lastName)
                && person.getPassportId().equals(this.passportId) && person.getAdress().equals(this.adress)
                && person.getAge() == this.age);
    }
    
    public String toString(){
        return "Firstname: " + this.getFirstname() + " Lastname: " + this.getLastName() +
                " PassportId: " + this.getPassportId() + " Age: "+this.getAge() 
                + " Address: " +this.getAdress().toString();
    }
    
}
