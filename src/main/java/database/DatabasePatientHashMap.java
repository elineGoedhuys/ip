/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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

    public DatabasePatientHashMap() {
        this.patients = new HashMap<Integer,Patient>();
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
    public int getLastId() {
       return 1;
    }

    @Override
    public int getNextId() {
       return getLastId()+1;
    }
    
    
}
