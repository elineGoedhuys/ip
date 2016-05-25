/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.doctor;

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
        } else if (type.equalsIgnoreCase("hash")){
            return new DatabaseDoctorHashMap();
        }else if (type.equalsIgnoreCase("JPA")){
            return new DoctorRelationalDatabase("HospitalPU");
        }
        return null;
    }
}
