/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.address;

import domain.Address;
import java.util.List;

/**
 *
 * @author Eline
 */
public interface DatabaseAddress {
    
    public void create(Address address);
    public List<Address> read();
    public void update(Address address);
    public void delete(long addressId);
    public Address getAddressOnId(long addressId);
    public void close();
}
