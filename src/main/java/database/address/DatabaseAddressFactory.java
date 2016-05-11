/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.address;

/**
 *
 * @author Eline
 */
public class DatabaseAddressFactory {
    
    public DatabaseAddressFactory(){
        
    }
    
    public DatabaseAddress DatabaseAddressFactory(String type){
        if(type == null){
            return null;
        }else if (type.equalsIgnoreCase("JPA")){
            return new AddressRelationalDatabase("HospitalPU");
        }
        return null;
    }
    
}
