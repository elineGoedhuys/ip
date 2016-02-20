/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Eline
 */
public class DatabasePatientFactory {
    
    public DatabasePatientFactory(){
        
    }
    
    public DatabasePatient DatabasePatientFactory(String type){
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("TXT")){
            return new DatabasePatientTXT();
        } else if (type.equalsIgnoreCase("db")){
            return new DatabasePatientDB();
        }
        return null;
    }
}
