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
public class Address {
    
    private String street;
    private String houseNumber;
    private String town;
    private String zipCode;
    private String region;
    private String country;
    
    public Address(String street, String houseNumber, String town, String zipCode, String region, String country){
       this.setStreet(street);
       this.setHouseNumber(houseNumber);
       this.setTown(town);
       this.setZipCode(zipCode);
       this.setRegion(region);
       this.setCountry(country);
    }
    
    public Address(){
        
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getRegion() {
        return region;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getZipCode() {
        return zipCode;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if(country.isEmpty() || country.equals("")){
            throw new IllegalArgumentException("Country can't be empty.");
        }
        this.country = country;
    }

    public void setHouseNumber(String houseNumber) {
        if(houseNumber.isEmpty() || houseNumber.equals("")){
            throw new IllegalArgumentException("Housenumber can't be empty.");
        }
        this.houseNumber = houseNumber;
    }

    public void setRegion(String region) {
        if(region.isEmpty() || region.equals("")){
            throw new IllegalArgumentException("Region can't be empty.");
        }
        this.region = region;
    }

    public void setStreet(String street) {
        if(street.isEmpty() || street.equals("")){
            throw new IllegalArgumentException("Street can't be empty.");
        }
        this.street = street;
    }

    public void setTown(String town) {
        if(town.isEmpty() || town.equals("")){
            throw new IllegalArgumentException("Town can't be empty.");
        }
        this.town = town;
    }

    public void setZipCode(String zipCode) {
        if(zipCode.isEmpty() || zipCode.equals("")){
            throw new IllegalArgumentException("zip code can't be empty");
        }
        this.zipCode = zipCode;
    }
    
    public String toString(){
        return "Street: " + this.getStreet() + " House number: " + this.getHouseNumber()
                + " Town: " + this.getTown() + " Zip code: " + this.getZipCode() + " Region: " + this.getRegion()
                + " Country: " + this.getCountry();
    }

    public String getAge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

   /** public String addressDatabaseFormat(){
        return this.getStreet() + " ; " + this.getHouseNumber() + " ; " + this.getZipCode() + " ; "
                + this.getTown() + " ; " + this.getRegion() + " ; " + this.getCountry()
                + " ; " +this.getAddressId() + "\n";
    }**/
    
    
    
}