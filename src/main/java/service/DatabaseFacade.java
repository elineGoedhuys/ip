/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.appointment.DatabaseAppointmentFacade;
import database.appointment.DatabaseAppointmentFactory;
import database.doctor.DatabaseDoctorFacade;
import database.doctor.DatabaseDoctorFactory;
import database.patient.DatabasePatientFacade;
import database.patient.DatabasePatientFactory;
import domain.Appointment;
import domain.Doctor;
import domain.Patient;
import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Eline
 */
public class DatabaseFacade {
    
    private DatabaseDoctorFacade doctorfacade;
    private DatabasePatientFacade patientfacade;
    private DatabaseAppointmentFacade appointmentfacade;
    private DatabaseAppointmentFactory appointmentfactory;
    private DatabaseDoctorFactory doctorfactory;
    private DatabasePatientFactory patientfactory;
    
            
    public void switchDatabse(String type){
        appointmentfactory.DatabaseAppointmentFactory(type);
        doctorfactory.DatabaseDoctorFactory(type);
        patientfactory.DatabasePatientFactory(type);
    }
    public DatabaseFacade(){
        doctorfacade = new DatabaseDoctorFacade();
        patientfacade = new DatabasePatientFacade();
        appointmentfacade = new DatabaseAppointmentFacade();
    }
   
    public DatabaseFacade(String type){
        doctorfacade = new DatabaseDoctorFacade();
        patientfacade = new DatabasePatientFacade();
        appointmentfacade = new DatabaseAppointmentFacade();
    }
    
    public List<Doctor> getDoctors(){
        return doctorfacade.read();
    }
    
    public List<Patient> getPatients(){
        return patientfacade.read();
    }
    
    public void newDoctor(Doctor doctor){
        doctorfacade.create(doctor);
    }
    
    public void newPatient(Patient patient){
        patientfacade.create(patient);
    }
    
    public void updateDoctor(Doctor doctor){
        doctorfacade.update(doctor);
    }
    
    public void updatePatient(Patient patient){
        patientfacade.update(patient);
    }
    
    public void deleteDocotor(int d){
        doctorfacade.delete(d);
    }
    
    public void deletePatient(int p){
        patientfacade.delete(p);
    }
    
    public void makeAppointment(Appointment appointment){
        appointmentfacade.makeNewAppointment(appointment);
    }
    
    public List<Appointment> getAllAppointments(){
        return appointmentfacade.getAllAppointments();
    }
    
    public void removeAppointment(int appointmentID){
        appointmentfacade.deleteAppointment(appointmentID);
    }
    
    public void updateAppointment(Appointment appointment){
        appointmentfacade.updateAppointment(appointment);
    }
    
}
