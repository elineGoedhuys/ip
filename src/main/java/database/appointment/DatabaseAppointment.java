/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.appointment;

import domain.Appointment;
import domain.Appointment1;
import java.util.List;

/**
 *
 * @author Eline
 */
public interface DatabaseAppointment {
    public void create(Appointment1 appointment);
    public List<Appointment1> read();
    public void update(Appointment1 appointment);
    public void delete(long appointmentId);
    public Appointment1 getAppointment(long appointmentId);
    public void close();

}
