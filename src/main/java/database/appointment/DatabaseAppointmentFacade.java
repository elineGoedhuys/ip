/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.appointment;


import domain.Appointment1;
import domain.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eline
 */
public class DatabaseAppointmentFacade {
    
    //public DatabaseAppointmentFactory facade = new DatabaseAppointmentFactory();
    //public DatabaseAppointment dbappointment = facade.DatabaseAppointmentFactory("JPA");
    public DatabaseAppointment dbappointment;
    
    public DatabaseAppointmentFacade(String dbType){
        DatabaseAppointmentFactory ft = new DatabaseAppointmentFactory();
        setDbappointment(ft.DatabaseAppointmentFactory(dbType));
    }

    public void setDbappointment(DatabaseAppointment dbappointment) {
        this.dbappointment = dbappointment;
    }

    public DatabaseAppointment getDbappointment() {
        return dbappointment;
    }
    
    
    
    public void makeNewAppointment(Appointment1 app)throws DbException{
        if(app == null){
            throw new IllegalArgumentException("Appointment can't be made.");
        }
        /**List<Appointment1> appointments = this.getAllAppointments();
        for(int i = 0; i != appointments.size(); i++){
            if (appointments.get(i).equals(app)){
                throw new IllegalArgumentException("Appointment can't be made.");
            }
        }**/
       
        dbappointment.create(app);
    }
    
    public List<Appointment1> getAllAppointments(){
        return dbappointment.read();
    }
    
    public void updateAppointment(Appointment1 app){
        dbappointment.update(app);
    }
    
    public void deleteAppointment(long appointmentid){
        dbappointment.delete(appointmentid);
    }

    public Appointment1 getAppointmentOnId(long appointmentId){
        return dbappointment.getAppointment(appointmentId);
    }
    
    public List<Appointment1> makeAgenda(Doctor doctor, String date){
        return dbappointment.makeAgenda(doctor, date);
    }
   
    public void close(){
        dbappointment.close();
    }
    
    /**public List<Appointment1> findAppointment(int patientId){
        List<Appointment1> apps = new ArrayList<Appointment1>();
        List<Appointment1> appointments = getAllAppointments();
        for(int i = 0; i != appointments.size(); i++){
            if(appointments.get(i).getPatientId() == patientId){
                apps.add(appointments.get(i));
            }
        }
        return apps;
    }**/

    public Object findAppointment(String patientId) {
      List<Appointment1> apps = new ArrayList<Appointment1>();
        List<Appointment1> appointments = getAllAppointments();
        for(int i = 0; i != appointments.size(); i++){
            if(appointments.get(i).getPatient().getId() == Integer.parseInt(patientId)){
                apps.add(appointments.get(i));
            }
        }
        return apps;
    }
    
}
