/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.doctor;

import domain.Doctor;
import domain.Patient;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eline
 */
public class DoctorRelationalDatabase implements DatabaseDoctor {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public DoctorRelationalDatabase(String name) {
        factory = Persistence.createEntityManagerFactory(name);
        manager = factory.createEntityManager();
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
    public void create(Doctor doctor) throws DbException {
        try {
            openConnection();
            manager.getTransaction().begin();
            manager.persist(doctor);
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new DbException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Doctor> read() throws DbException {
        try {
            openConnection();
            List<Doctor> list = manager.createQuery("select d from Doctor d", Doctor.class).getResultList();

            return list;
        } catch (Exception e) {
            throw new DbException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void update(Doctor doctor) throws DbException {
        try {
            openConnection();
            this.delete(doctor.getId());
            this.create(doctor);
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new DbException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void delete(long doctorid) throws DbException {
        try {
            openConnection();
            manager.getTransaction().begin();
            Doctor d = manager.find(Doctor.class, doctorid);
            manager.remove(d);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new DbException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public Doctor getDoctorOnId(long doctorId) throws DbException {
        try {
            openConnection();
            Doctor d = manager.find(Doctor.class, doctorId);

            return d;
        } catch (Exception e) {
            throw new DbException();
        } finally {
            closeConnection();
        }
    }

}
