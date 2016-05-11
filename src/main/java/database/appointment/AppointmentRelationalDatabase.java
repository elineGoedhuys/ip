/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.appointment;

import domain.Appointment1;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eline
 */
public class AppointmentRelationalDatabase implements DatabaseAppointment {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public AppointmentRelationalDatabase(String name) {
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
    public void create(Appointment1 appointment) throws DbException {
        try {
            openConnection();
            manager.getTransaction().begin();
            manager.persist(appointment);
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
    public List<Appointment1> read() {
        try {
            openConnection();
            List<Appointment1> list = manager.createQuery("select a from Appointment1 a", Appointment1.class).getResultList();

            return list;
        } catch (Exception e) {
            throw new DbException(e.getMessage(), e);
        } finally {
            closeConnection();
        }

    }

    @Override
    public void update(Appointment1 appointment) {
        try {
            openConnection();
            this.delete(appointment.getAppointmentId());
            this.create(appointment);
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new DbException(e.getMessage(), e);
        } finally {
            closeConnection();
        }

    }

    @Override
    public void delete(long appointmentId) {
        try {
            openConnection();
            manager.getTransaction().begin();
            Appointment1 a = manager.find(Appointment1.class, appointmentId);
            manager.remove(a);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new DbException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public Appointment1 getAppointment(long appointmentId) {
        try {
            openConnection();
            Appointment1 a = manager.find(Appointment1.class, appointmentId);

            return a;
        } catch (Exception e) {
            throw new DbException();
        } finally {
            closeConnection();
        }
    }

  
}
