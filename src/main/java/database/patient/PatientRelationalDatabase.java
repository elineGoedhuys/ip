/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.patient;

import domain.Patient;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eline
 */
public class PatientRelationalDatabase implements DatabasePatient{

    private EntityManagerFactory factory;
    private EntityManager manager;
    
    public PatientRelationalDatabase(String name) {
        factory = Persistence.createEntityManagerFactory(name);
        //manager = factory.createEntityManager();
    }

    public void openConnection() {
        try {
            manager = factory.createEntityManager();
        } catch (Exception e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    public void close() {
        try {
            factory.close();
        } catch (Exception e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    public void closeConnection() throws DbException {
        try {
            manager.close();
            //factory.close();
        } catch (Exception e) {
            throw new DbException(e.getMessage(), e);
        }
    }
    
    
    @Override
    public void create(Patient patient) throws DbException {
        System.out.println(patient.toString());
        try {  
            openConnection();
            manager.getTransaction().begin();
            manager.persist(patient);
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new DbException(e.getMessage(),e);
        } finally{
            closeConnection();
    }
    
    }

    

    @Override
    public List<Patient> read() throws DbException {
        try {
            openConnection();
           //manager.getTransaction().begin();
           List<Patient> list = manager.createQuery("select p from Patient p", Patient.class).getResultList();
           //manager.flush();
          // manager.getTransaction().commit();
           return list;
        } catch (Exception e) {
            throw new DbException(e.getMessage(), e);
        } finally{
            closeConnection();
        }
    }

    @Override
    public void update(Patient patient) throws DbException {
        try {
            openConnection();
            manager.getTransaction().begin();
            manager.merge(patient);
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new DbException(e.getMessage(),e);
        } finally{
            closeConnection();
        }
    }

    @Override
    public void delete(long patientid) throws DbException{
        try {
            openConnection();
            manager.getTransaction().begin();
            Patient p = manager.find(Patient.class, patientid);
            manager.remove(p);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new DbException(e.getMessage(),e);
        } finally{
            closeConnection();
        }
    }

    @Override
    public Patient getPatientOnId(long patientId) throws DbException{
        try {
            openConnection();
            Patient p = manager.find(Patient.class, patientId);
            
            return p;
        } catch (Exception e) {
            throw new DbException();
        } finally{
            closeConnection();
        }
    }

    @Override
    public Patient getPatientOnName(String name) {
        try {
            openConnection();
            Patient p = manager.find(Patient.class, name);
            
            return p;
        } catch (Exception e) {
            throw new DbException();
        } finally{
            closeConnection();
        }
    }

   
    
}
