/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.patient;

import domain.Patient;
import java.util.List;

/**
 *
 * @author Eline
 */
public interface DatabasePatient {
    
    public void create(Patient patient);
    public List<Patient> read();
    public void update(Patient patient);
    public void delete(long patientid);
    public Patient getPatientOnId(long patientId);
    public void close();
}
