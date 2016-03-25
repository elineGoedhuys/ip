/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.patient;

import domain.Address;
import domain.Patient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Eline
 */
public class DatabasePatientHashMap implements DatabasePatient {

    private HashMap<Integer,Patient> patients;
    private Address address = new Address("Wijnberg", "48", "Rillaar", "3202", "Vlaams-Brabant", "Belgium");
    private Patient patient = new Patient("Eline", "Goedhuys","1203553", address, 22, 123);

    public DatabasePatientHashMap() {
        this.patients = new HashMap<Integer,Patient>();
        create(patient);
        
    }
    
    @Override
    public void create(Patient patient) {
        patients.put(patient.getPatientId(), patient);
    }

    @Override
    public List<Patient> read() {
       List<Patient> ps = new ArrayList<>(patients.values());
       return ps;
    }

    @Override
    public void update(Patient patient) {
       patients.remove(patient.getPatientId(), patient);
       patients.put(patient.getPatientId(), patient);
    }

    @Override
    public void delete(int patientid) {
        patients.remove(patientid);
    }

    @Override
    public Patient getPatientOnId(int patientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLastId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNextId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}