/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.appointment;

import domain.Appointment;
import java.util.List;

/**
 *
 * @author Eline
 */
public class DatabaseAppointmentFacade {
    
    public DatabaseAppointmentFactory facade = new DatabaseAppointmentFactory();
    public DatabaseAppointment dbappointment = facade.DatabaseAppointmentFactory("hash");
    
    public void makeNewAppointment(Appointment app){
        if(app == null){
            throw new IllegalArgumentException();
        }
        List<Appointment> appointments = dbappointment.read();
        if(appointments.isEmpty()){
            dbappointment.create(app);
        }
        if(appointments.contains(app)){
            throw new IllegalArgumentException("You can't make an appointment.");
        }
        dbappointment.create(app);
    }
    
    public List<Appointment> getAllAppointments(){
        return dbappointment.read();
    }
    
    public void updateAppointment(Appointment app){
        dbappointment.update(app);
    }
    
    public void deleteAppointment(int appointmentid){
        dbappointment.delete(appointmentid);
    }

   
}
