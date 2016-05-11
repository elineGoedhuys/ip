/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.address;

import domain.Address;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eline
 */
public class AddressRelationalDatabase implements DatabaseAddress {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public AddressRelationalDatabase(String name) {
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
    public void create(Address address) {
        try {
            openConnection();
            manager.getTransaction().begin();
            manager.persist(address);
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
    public List<Address> read() {
        try {
            openConnection();
            List<Address> list = manager.createQuery("select a from Address a", Address.class).getResultList();

            return list;
        } catch (Exception e) {
            throw new DbException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void update(Address address) {
        try {
            openConnection();
            this.delete(address.getId());
            this.create(address);
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new DbException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void delete(long addressId) {
        try {
            openConnection();
            manager.getTransaction().begin();
            Address a = manager.find(Address.class, addressId);
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
    public Address getAddressOnId(long addressId) {
        try {
            openConnection();
            Address a = manager.find(Address.class, addressId);

            return a;
        } catch (Exception e) {
            throw new DbException();
        } finally {
            closeConnection();
        }
    }

}
