/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Address;
import domain.Appointment1;
import domain.Doctor;
import domain.Patient;
import domain.Person;
import java.util.Set;
import service.DatabaseFacade;

/**
 *
 * @author Eline
 */
public class TestService {
    
    public static void main(String[] args){
       Address address = new Address("Wijnberg","48","Rillaar","3202","Vlaams-Brabant","Belgium");
      Person patient = new Patient("Griet","Goedhuys","BE2356542",address,33);
        
       /**service.newPatient(patient);
        System.out.println(service.getPatients());**/
      DatabaseFacade service = new DatabaseFacade();
       Person doctor = new Doctor("Jan","Janssens","BE2456543",address,33);
        //service.newDoctor(doctor);
        //System.out.println(service.getDoctors());
       /**service.deletePatient(651);**/
        Person p = service.getPatientOnId(901);
      Person d = service.getDoctorOnId(851);
      Appointment1 app = new Appointment1(p,d,"hospital","08:00","12 Juni 2016");
      //service.makeAppointment(app);

      // service.newPatient(patient);
        System.out.println(service.getPatients());
        //System.out.println(service.findAppointment(901));
        //System.out.println(service.getAllAppointments());
        System.out.println(p.toString());
        System.out.println(d.toString());
        //service.makeAppointment(app);
        //System.out.println(service.getAllAppointments());
        System.out.println(app.toString());
    }
    
    
}
