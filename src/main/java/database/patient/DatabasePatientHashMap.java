/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.patient;

import domain.Address;
import domain.Patient;
import domain.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Eline
 */
public class DatabasePatientHashMap implements DatabasePatient {

    private final HashMap<Long,Patient> patients;
    /**private final Address address = new Address("Wijnberg", "48", "Rillaar", "3202", "Vlaams-Brabant", "Belgium");
    private final Address address1 = new Address("Paepestraat", "36", "Boortmeerbeek", "3190", "Antwerpen", "Belgium");
    private final Person patient = new Patient("Eline", "Goedhuys","1203553", new Address("Wijnberg", "48", "Rillaar", "3202", "Vlaams-Brabant", "Belgium"), 22, 123);
    private final Patient patient1 = new Patient("Margot", "Dewree","1203478", address1, 5, 124);
    private final Patient patient2 = new Patient("Matthias", "Dewree","12031233", address1, 4, 125);**/

    public DatabasePatientHashMap() {
        this.patients = new HashMap<Long,Patient>();
        /**create(patient);
        create(patient1);
        create(patient2);**/
        
    }
    
    @Override
    public void create(Patient patient) {
        patients.put(patient.getId(), patient);
    }

    @Override
    public List<Patient> read() {
       List<Patient> ps = new ArrayList<>(patients.values());
       return ps;
    }

    @Override
    public void update(Patient patient) {
       patients.remove(patient.getId(), patient);
       patients.put(patient.getId(), patient);
    }

    @Override
    public void delete(long patientid) {
        patients.remove(patientid);
    }

    @Override
    public Patient getPatientOnId(long patientId) {
        List<Patient> patients1 = this.read();
        for(int i= 0; i != patients1.size(); i++){
            if(patients1.get(i).getId() == patientId){
                return patients1.get(i);
            }
        }
        return null;
    }    

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}