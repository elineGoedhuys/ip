/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Eline
 * Deze klasse wordt niet gebruikt.
 */
public class ScheduleAppointment {
    
    private ArrayList<Appointment> appointments;
    
    public ScheduleAppointment(){
        appointments = new ArrayList<>();
    }
    
    public void makeNewAppointment(Appointment appointment){
        if(appointment == null){
            throw new IllegalArgumentException("Appointment can't be empty.");
        }
        for(int i = 0; i != appointments.size(); i++){
            if(appointments.get(i).getDate().equals(appointment.getDate())
                    && appointments.get(i).getDocterID() == (appointment.getDocterID())){
                throw new IllegalArgumentException("You can't make an appointment at this time.");
            }
            
        }
        this.appointments.add(appointment);
    }
    
    public void removeAppointment(int appointmentId){
        for(int i = 0; i != appointments.size(); i++){
            if(appointments.get(i).getAppointmentId() == appointmentId){
                this.appointments.remove(i);
            }else{
                throw new IllegalArgumentException("Appointment can't be found");
            }
        }
    }
    
    public String toString(){
        String out = "";
        for(Appointment app : this.appointments){
            out += app.toString() + "\n";
        }
        return out;
    }
}
