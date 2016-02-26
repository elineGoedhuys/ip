/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.patient;

import domain.Address;
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
public class DatabasePatientTXT implements DatabasePatient {

    File file = new File("patient.txt");
    
    public DatabasePatientTXT(){
        
    }
    
    @Override
    public void create(Patient patient) {
        FileWriter fw = null;
       PrintWriter pw = null;
       try{
          fw = new FileWriter(file,true);
          pw = new PrintWriter(fw);
          pw.write(patient.DatabaseFormat());
          pw.close();
          fw.close();
       }catch(IOException ex){
           ex.getMessage();
       } 
    }

    @Override
    public List<Patient> read() {
    List<Patient> list = new ArrayList<>();
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
                int age = Integer.parseInt(sc1.next().trim());
                String patientid = sc1.next();
                Integer patid = Integer.parseInt(patientid.trim());
                Address address = new Address(street,housenumber,town,zipcode,region,country);
                Patient patient = new Patient(firstname,lastname,passportid,address,age,patid);
                list.add(patient);
                sc1.close();
            }
            
            sc.close();
            return list;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabasePatientTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list;    }

    @Override
    public void update(Patient patient) {
       this.delete(patient.getPatientId());
       this.create(patient);
    }

    @Override
    public void delete(int patientid){
        for(int i = 0; i != read().size(); i++){
            if(read().get(i).getPatientId() == patientid){
                read().remove(i);
            }
        }
    }

    @Override
    public int getLastId() {
        int last = 0;
        for(int i = 0; i != read().size(); i++){
            if(read().get(i).getPatientId() > last){
                last = read().get(i).getPatientId();
            }
        }
        return last;
    }

    @Override
    public int getNextId() {
        return this.getLastId()+1;
    }
    
    
}
