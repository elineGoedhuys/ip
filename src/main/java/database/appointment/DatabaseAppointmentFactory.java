/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.appointment;

import database.doctor.DatabaseDoctor;
import database.doctor.DatabaseDoctorDB;
import database.doctor.DatabaseDoctorHashMap;
import database.doctor.DatabaseDoctorTXT;

/**
 *
 * @author Eline
 */
public class DatabaseAppointmentFactory {
    
    
    public DatabaseAppointmentFactory(){
        
    }
    
    
     public DatabaseAppointment DatabaseAppointmentFactory(String type){
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("TXT")){
            return new DatabaseAppointmentTXT();
        } else if (type.equalsIgnoreCase("db")){
            return new DatabaseAppointmentDB();
        } else if(type.equalsIgnoreCase("hash")){
            return new DatabaseAppointmentHashMap();
        } else if (type.equalsIgnoreCase("JPA")){
            return new AppointmentRelationalDatabase("HospitalPU");
        }
        return null;
    }
    
}
