/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.appointment;


import domain.Appointment1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Eline
 */
public class DatabaseAppointmentHashMap implements DatabaseAppointment {
    
    private final HashMap<Long,Appointment1> appointments;
    
    public DatabaseAppointmentHashMap(){
        appointments= new HashMap<Long,Appointment1>();
    }

    @Override
    public void create(Appointment1 appointment) {
       appointments.put(appointment.getId(), appointment);
    }

    @Override
    public List<Appointment1> read() {
       List<Appointment1> ps = new ArrayList<>(appointments.values());
       return ps;
    }

    @Override
    public void update(Appointment1 appointment) {
        appointments.remove(appointment.getId(), appointment);
        appointments.put(appointment.getId(), appointment);
    }

    @Override
    public void delete(long appointmentId) {
        appointments.remove(appointmentId);
    }

    @Override
    public Appointment1 getAppointment(long appointmentId) {
        List<Appointment1> appointments = this.read();
        for(int i = 0; i != appointments.size(); i++){
            if(appointments.get(i).getId() == appointmentId){
                return appointments.get(i);
            }
        }
        return null;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
    
    
}
