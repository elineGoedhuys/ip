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
public interface DatabaseAppointment {
    public void create(Appointment appointment);
    public List<Appointment> read();
    public void update(Appointment appointment);
    public void delete(int appointmentId);
}
