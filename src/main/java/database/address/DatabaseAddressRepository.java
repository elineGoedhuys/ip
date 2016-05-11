/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.address;

import domain.Address;
import java.util.List;

/**
 *
 * @author Eline
 */
public class DatabaseAddressRepository {
    
    private DatabaseAddressFactory ft = new DatabaseAddressFactory();
    private DatabaseAddress db = ft.DatabaseAddressFactory("JPA");
    
    public DatabaseAddressRepository(){
        
    }
    
    public void create(Address address){
        if(address == null){
            throw new IllegalArgumentException("Nothing to create.");
        }
        db.create(address);
    }
    
    public List<Address> read(){
        return db.read();
    }
    
    public void update(Address address){
        if(address == null){
            throw new IllegalArgumentException("Nothing to create.");
        }
        db.update(address);
    }
    
    public void delete(int addressid){
        db.delete(addressid);
    }
    
    public Address getAddressOnId(int addressId){
        return db.getAddressOnId(addressId);
    }
    
    public void close(){
        db.close();
    }
}
