/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.address.DatabaseAddressFactory;
import database.address.DatabaseAddressRepository;
import database.appointment.DatabaseAppointmentFacade;
import database.appointment.DatabaseAppointmentFactory;
import database.doctor.DatabaseDoctorFacade;
import database.doctor.DatabaseDoctorFactory;
import database.patient.DatabasePatientFacade;
import database.patient.DatabasePatientFactory;
import domain.Address;
import domain.Appointment1;
import domain.Doctor;
import domain.Patient;
import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.List;
import rest.RestWeather;

/**
 *
 * @author Eline
 */
public class DatabaseFacade {
    
    private DatabaseDoctorFacade doctorfacade;
    private DatabasePatientFacade patientfacade;
    private DatabaseAppointmentFacade appointmentfacade;
    private DatabaseAddressRepository addressfacade;
    private RestWeather restWeather;
    private DatabaseAppointmentFactory appointmentfactory;
    private DatabaseDoctorFactory doctorfactory;
    private DatabasePatientFactory patientfactory;
    private DatabaseAddressFactory addressfactory;
    
            
    public void switchDatabse(String type){
        appointmentfactory.DatabaseAppointmentFactory(type);
        doctorfactory.DatabaseDoctorFactory(type);
        patientfactory.DatabasePatientFactory(type);
        addressfactory.DatabaseAddressFactory(type);
    }
    public DatabaseFacade(){
        doctorfacade = new DatabaseDoctorFacade();
        patientfacade = new DatabasePatientFacade();
        appointmentfacade = new DatabaseAppointmentFacade();
        addressfacade = new DatabaseAddressRepository();
        restWeather = new RestWeather();
    }
   
    public DatabaseFacade(String type){
        doctorfacade = new DatabaseDoctorFacade();
        patientfacade = new DatabasePatientFacade();
        appointmentfacade = new DatabaseAppointmentFacade();
        addressfacade = new DatabaseAddressRepository();
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
    
    public void deleteDocotor(long d){
        doctorfacade.delete(d);
    }
    
    public void deletePatient(long p){
        patientfacade.delete(p);
    }
    
    public void makeAppointment(Appointment1 appointment){
        appointmentfacade.makeNewAppointment(appointment);
    }
    
    public List<Appointment1> getAllAppointments(){
        return appointmentfacade.getAllAppointments();
    }
    
    public void removeAppointment(int appointmentID){
        appointmentfacade.deleteAppointment(appointmentID);
    }
    
    public void updateAppointment(Appointment1 appointment){
        appointmentfacade.updateAppointment(appointment);
    }
    
    public Patient getPatientOnId(long patientId){
        return patientfacade.getPatientOnId(patientId);
    }
    
    public Doctor getDoctorOnId(long doctorId){
        return doctorfacade.getDoctorOnId(doctorId);
    }
    
    public Patient getPatientOnName(String name){
        return patientfacade.getPatientOnName(name);
    }
    
    public Doctor getDoctorOnName(String name){
        return doctorfacade.getDoctorOnName(name);
    }
    
    public Appointment1 getAppointmentOnId(int appointmentId){
        return appointmentfacade.getAppointmentOnId(appointmentId);
    }
    
    public void newAddress(Address address){
        addressfacade.create(address);
    }
    
    public void removeAddress(int addresId){
        addressfacade.delete(addresId);
    }
    
    public void updateAddress(Address address){
        addressfacade.update(address);
    }
    
    public List<Address> getAllAddresses(){
        return addressfacade.read();
    }
    
    public Address getAddress(int addressId){
        return addressfacade.getAddressOnId(addressId);
    }
    
    /**public List<Appointment1> findAppointment(int patientId){
        return appointmentfacade.findAppointment(patientId);
    }**/
    
    public void close(){
        patientfacade.close();
        doctorfacade.close();
        addressfacade.close();
        appointmentfacade.close();
    }

    public Object findAppointment(String patientId) {
        return appointmentfacade.findAppointment(patientId);
    }
    
    public String getWeather(){
        return restWeather.getWeather();
    }
}
