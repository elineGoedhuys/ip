/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.doctor;

import domain.Doctor;
import java.util.List;

/**
 *
 * @author Eline
 */
public interface DatabaseDoctor {
     public void create(Doctor doctor);
    public List<Doctor> read();
    public void update(Doctor doctor);
    public void delete(int doctroId);
    public int getLastId();
    public int getNextId();
}
