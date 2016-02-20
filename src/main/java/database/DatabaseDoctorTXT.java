/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Address;
import domain.Doctor;
import domain.Patient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eline
 */
public class DatabaseDoctorTXT implements DatabaseDoctor{

    File file = new File("doctor.txt");
            
    public DatabaseDoctorTXT(){
        
    }
    
    @Override
    public void create(Doctor doctor) {
         FileWriter fw = null;
       PrintWriter pw = null;
       try{
          fw = new FileWriter(file,true);
          pw = new PrintWriter(fw);
          pw.write(doctor.DatabaseFormat());
          pw.close();
          fw.close();
       }catch(IOException ex){
           ex.getMessage();
       } 
    }

    @Override
    public List<Doctor> read() {
        List<Doctor> list = new ArrayList<>();
            try{
            Scanner sc;
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                Scanner sc1 = new Scanner(sc.nextLine()).useDelimiter(";");
                String firstname = sc1.next();
                String lastname = sc1.next();
                String passportid = sc1.next();
                String street = sc1.next();
                String housenumber = sc1.next();
                String town = sc1.next();
                String zipcode = sc1.next();
                String region = sc1.next();
                String country = sc1.next();
                Integer doctorid = Integer.parseInt(sc1.next());
                Address address = new Address(street,housenumber,town,zipcode,region,country);
                Doctor doctor = new Doctor(firstname,lastname,passportid,address,doctorid);
                list.add(doctor);
                sc1.close();
            }
            
            sc.close();
            return list;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabasePatientTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list;    

    }

    @Override
    public void update(Doctor doctor) {
        this.delete(doctor.getDoctorId());
        this.create(doctor);
    }

    @Override
    public void delete(int doctroId) {
         for(int i = 0; i != read().size(); i++){
            if(read().get(i).getDoctorId() == doctroId){
                read().remove(i);
            }
        }
    }

    @Override
    public int getLastId() {
                int last = 0;
        for(int i = 0; i != read().size(); i++){
            if(read().get(i).getDoctorId() > last){
                last = read().get(i).getDoctorId();
            }
        }
        return last;

    }

    @Override
    public int getNextId() {
        return getLastId()+1;
    }
    
}
