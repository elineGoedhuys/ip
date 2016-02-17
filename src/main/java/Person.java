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
        this.setFirstName(firstname);
        this.setLastName(lastname);
        this.setPassportId(passportId);
        this.setAdress(adress);
        this.setAge(age);
    }

    private void setFirstName(String firstname){
       if (firstName.isEmpty() || firstName.equals(" ")){
          throw new IllegalArgumentException("Firstname can't be empty");
       }
       this.firstName = firstname;
    }

    private void setLastName(String lastname) {
        if (lastName.isEmpty() || lastName.equals("")){
            throw new IllegalArgumentException("Lastname can't be empty");
        }
        this.lastName = lastname;
    }

    private void setPassportId(String passportId) {
      if (passportId.isEmpty() || passportId.equals("")){
          throw new IllegalArgumentException("passportId can't be empty");
      }
      this.passportId = passportId;
    }

    private void setAdress(Address adress) {
       if (adress == null){
           throw new IllegalArgumentException();
       }
       this.adress = adress;
    }

    private void setAge(int age) {
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
    
}
