package domain;



import service.DatabaseFacade;
import database.appointment.DatabaseAppointmentFacade;
import database.doctor.DatabaseDoctorFacade;
import database.patient.DatabasePatientFacade;
import database.patient.DatabasePatientTXT;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eline
 */
public class main {
    
    public static void main(String[] args) {
        /**Address a = new Address("Wijnberg", "48", "3202", "Rillaar", "Vlaams - Brabant", "Belgium");
        Docter d = new Docter("Eline", "Goedhuys", "122345", a, 22, "222");
        Patient p = new Patient("Griet", "Goedhuys", "12234", a, 33, "111");
        Hospital h = new Hospital("UZ");
        Date date = new Date(2016, 05, 11);
        Appointment app = new Appointment(d, p, date, "D.13", h);

        h.addAppointment(app);
        h.addDocter(d);
        h.addPatient(p);
        System.out.println(h.stringPatients());
        System.out.println(h.stringDocters());
        System.out.println(h.stringAppointments());
       Address a = new Address ("Wijnberg", "48", "3202","Rillaar","Vlaams-Brabant","Belgium","1");
       Address b = new Address("Keizerlei", "33", "2000","Antwerpen","Antwerpen","Belgium","2");
        DatabaseAddressTXT db = new DatabaseAddressTXT();
        db.create(b);
        db.create(a);
        List<Address> ad = db.read();
        
        System.out.println(ad.toString());**/
        /**Hospital h = new Hospital("uz");**/
       /**DatabaseDoctorFacade db = new DatabaseDoctorFacade();
        /**Address a = new Address ("Wijnberg", "48", "3202","Rillaar","Vlaams-Brabant","Belgium");
        Patient pr = new Patient("Eline","Goedhuys","1223",a,22);
        System.out.println(pr.toString());**/
        /**Address a1 = new Address ("Wijnberg", "48", "3202","Rillaar","Vlaams-Brabant","Belgium");
        Patient pr2 = new Patient("Eline","Goedhuys","1223",a1,22);
        /**h.addPatient((Patient) pr);
        h.addPatient((Patient) pr2);
        System.out.println(h.getPatients().toString());**/
        /**db.create(pr);**/
        /**db.create(pr2);
        System.out.println(db.read().toString());
       System.out.println(db.getNextId());
        DatabasePatientTXT db1 = new DatabasePatientTXT();
        System.out.println(db1.getLastId());
        System.out.println(db1.getNextId());
        /**System.out.println(db.read().toString());
        /**System.out.println(db.getNextId());
        * 
        */
        /**System.out.println(db.getNextId());
        System.out.println(db.read());
        /**Address a1 = new Address ("Wijnberg", "48", "3202","Rillaar","Vlaams-Brabant","Belgium");
        Doctor pr2 = new Doctor("Eline","Goedhuys","1223",a1,22);
        db.create(pr2);**/
        /**try{
        Hospital h = new Hospital();
        /**System.out.println(h.getDoctors());
        System.out.println(h.getPatients());**/
       /** Address a1 = new Address ("Wijnberg", "48", "3202","Rillaar","Vlaams-Brabant","Belgium");
        /**Doctor dr2 = new Doctor("Eline","Goedhuys","1223",a1,22);
        Patient pr2 = new Patient("Eline","Goedhuys","1223",a1,22);
        h.addDocter(dr2);
        Date date = new Date(2015,02,15,8,10);
        Appointment app = new Appointment(dr2,pr2,date,"H2",h);
        ScheduleAppointment mapp = new ScheduleAppointment();
        mapp.makeNewAppointment(app);
        mapp.removeAppointment(app.getAppointmentId());
        /**System.out.println(h.getDoctors());
        h.addPatient(pr2);
        System.out.println(h.getPatients());**/
        /**System.out.println(mapp.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        **/
        /**DatabaseFacade df = new DatabaseFacade();
        DatabasePatientTXT dp = new DatabasePatientTXT();
        dp.getPatientOnId(1);**/
        
     
            Address a1 = new Address ("Wijnberg", "48", "3202","Rillaar","Vlaams-Brabant","Belgium");
            Doctor d = new Doctor("Eline","Goedhuys","1223",a1,22,334456);
            Patient p = new Patient("Eline","Goedhuys","1223",a1,22,3467);
            String date = new String("12 maart 2017");        
            /**Appointment app = new Appointment(123,d.getDoctorId(),p.getPatientId(),date,"somewhere");
            DatabaseAppointmentFacade facade = new DatabaseAppointmentFacade();
            facade.makeNewAppointment(app);
            System.out.println(facade.getAllAppointments().toString());
            System.out.println(app.getAppointmentId());**/
            DatabaseFacade facade = new DatabaseFacade();
            facade.newDoctor(d);
            System.out.println(facade.getPatients());
            System.out.println(facade.getDoctors());
           
    }
    
    
    
}
