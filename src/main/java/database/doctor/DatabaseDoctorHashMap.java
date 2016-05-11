/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.doctor;

import domain.Address;
import domain.Doctor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Eline
 */
public class DatabaseDoctorHashMap implements DatabaseDoctor {
    
    
    private static Map<Long, Doctor> doctors;
   /** private final Doctor doctor;**/
    /**private Address address = new Address("Wilrijkstraat","10","Edegem","2650","Antwerp","Belgium");**/

  
    public DatabaseDoctorHashMap() {
        /**this.doctor = new Doctor("Jan","Janssens","12347357",address,55,102);**/
        this.doctors = new HashMap<Long,Doctor>();
        /**create(doctor);**/
    }

   
    
    @Override
    public void create(Doctor doctor) {
       this.doctors.put(doctor.getId(), doctor);
    }

    @Override
    public List<Doctor> read() {
       List<Doctor> ds = new ArrayList<Doctor>(doctors.values());
       return ds;
    }

    @Override
    public void update(Doctor doctor) {
        this.doctors.remove(doctor.getId(), doctor);
        this.doctors.put(doctor.getId(), doctor);
    }

    @Override
    public void delete(long doctroId) {
        this.doctors.remove(doctroId);
    }

    @Override
    public Doctor getDoctorOnId(long doctorId) {
    List<Doctor> doctors1 = this.read();
        for(int i= 0; i != doctors1.size(); i++){
            if(doctors1.get(i).getId() == doctorId){
                return doctors1.get(i);
            }
        }
        return null;    
    
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
