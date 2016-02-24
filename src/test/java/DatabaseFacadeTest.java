/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.org.apache.regexp.internal.RETest.test;
import database.DatabaseFacade;
import domain.Address;
import domain.Doctor;
import domain.Patient;
import domain.Person;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eline
 */
public class DatabaseFacadeTest {
    
    private DatabaseFacade databasefacade;
    private Patient patient;
    private Doctor doctor;
    private Doctor doctor1;
    private Address address;
    private List<Patient> patients;
    private List<Doctor> doctors;
    
     @Before
    public void setUp() {
         this.address = new Address("Wijnberg","48","3202","Rillaar","Vlaams-Brabant","Belgium");
        this.patient = new Patient("Eline","Goedhuys","1223",address,22,1);
        this.doctor = new Doctor("Eline","Goedhuys","1223",address,22,1);
        this.doctor1 = new Doctor("Eline","Goedhuys","1223",address,22,2);
        
        databasefacade = new DatabaseFacade();
        this.patients = new ArrayList<Patient>();
        this.doctors = new ArrayList<Doctor>();
        patients.add(patient);
        doctors.add(doctor);
        doctors.add(doctor1);
        
    }
    
    @Test
    public void test_get_patients(){
        List<Patient> p = databasefacade.getPatients();
        assertEquals(p,this.patients);
    }
    
    @Test
    public void test_get_Doctors(){
        List<Doctor> d = databasefacade.getDoctors();
        assertEquals(d,this.doctors);
    }
            
    @Test
    public void test_new_doctor(){
        Doctor d = new Doctor("Griet","Goedhuys","1111",this.address,32,3);
        List<Doctor> ds = this.doctors;
        ds.add(d);
        databasefacade.newDoctor(d);
        assertEquals(ds,databasefacade.getDoctors());
    }
    
    @Test
    public void test_new_patient(){
        Patient p = new Patient("Griet","Goedhuys","1111",this.address,32,2);
        List<Patient> ps = this.patients;
        ps.add(p);
        databasefacade.newPatient(p);
        assertEquals(ps,databasefacade.getPatients());
    }
    
    @Test
    public void test_update_doctor(){
        Doctor d = new Doctor("Eline","Goedhuys","1223",this.address,23,1);
        List<Doctor> ds = this.doctors;
        ds.remove(0);
        ds.add(0, d);
        databasefacade.updateDoctor(d);
        assertEquals(ds,databasefacade.getDoctors());
    }
    
    @Test
    public void test_update_patient(){
        Patient p = new Patient("Eline","Goedhuys","1223",address,23,1);
        List<Patient> ps = this.patients;
        ps.remove(0);
        ps.add(0, p);
        databasefacade.updatePatient(p);
        assertEquals(ps,databasefacade.getPatients());
    }
    
    @Test
    public void test_remove_doctor(){
        databasefacade.deleteDocotor(1);
        this.doctors.remove(0);
        assertEquals(this.doctors,databasefacade.getDoctors());
    }
    
    @Test
    public void test_remove_patient(){
        databasefacade.deletePatient(1);
        this.patients.remove(0);
        assertEquals(this.patients,databasefacade.getPatients());
    }
    
    
    
            
  
    
   
    
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
