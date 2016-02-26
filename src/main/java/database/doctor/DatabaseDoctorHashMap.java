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

/**
 *
 * @author Eline
 */
public class DatabaseDoctorHashMap implements DatabaseDoctor {
    
    
    private final HashMap<Integer, Doctor> doctors;

  
    public DatabaseDoctorHashMap() {
        this.doctors = new HashMap<Integer,Doctor>();
    }

   
    
    @Override
    public void create(Doctor doctor) {
       this.doctors.put(doctor.getDoctorId(), doctor);
    }

    @Override
    public List<Doctor> read() {
       List<Doctor> ds = new ArrayList<Doctor>(doctors.values());
       return ds;
    }

    @Override
    public void update(Doctor doctor) {
        this.doctors.remove(doctor.getDoctorId(), doctor);
        this.doctors.put(doctor.getDoctorId(), doctor);
    }

    @Override
    public void delete(int doctroId) {
        this.doctors.remove(doctroId);
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
