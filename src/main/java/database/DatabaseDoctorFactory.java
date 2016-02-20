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
public class DatabaseDoctorFactory {
    
    public DatabaseDoctorFactory(){
        
    }
    
    
    public DatabaseDoctor DatabaseDoctorFactory(String type){
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("TXT")){
            return new DatabaseDoctorTXT();
        } else if (type.equalsIgnoreCase("db")){
            return new DatabaseDoctorDB();
        }
        return null;
    }
}
