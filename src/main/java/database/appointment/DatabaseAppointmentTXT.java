/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.appointment;

import database.patient.DatabasePatientTXT;
import domain.Address;
import domain.Appointment;
import domain.Appointment1;
import domain.Doctor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eline
 */
public class DatabaseAppointmentTXT implements DatabaseAppointment {

    File file = new File("appointment.txt");
            
    public DatabaseAppointmentTXT(){
        
    }
    
    @Override
    public void create(Appointment1 appointment) {
       FileWriter fw = null;
       PrintWriter pw = null;
       /**try{
          fw = new FileWriter(file,true);
          pw = new PrintWriter(fw);
          pw.write(appointment.DatabaseFormat());
          pw.close();
          fw.close();
       }catch(IOException ex){
           ex.getMessage();
       } **/
    }

    @Override
    public List<Appointment1> read() 
   {
       List<Appointment1> list = new ArrayList<>();
           /** try{
            Scanner sc;
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                Scanner sc1 = new Scanner(sc.nextLine()).useDelimiter(";");
                Integer appointmentId = Integer.parseInt(sc1.next());
                Integer docterid = Integer.parseInt(sc1.next());
                Integer patientid = Integer.parseInt(sc1.next());
                String date = sc1.next();
                String hour = sc1.next();
                String place = sc1.next();
                Appointment1 app = new Appointment1(appointmentId,docterid,patientid,date,hour,place);
                list.add(app);
                sc1.close();
            }
            sc.close();
            return list;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabasePatientTXT.class.getName()).log(Level.SEVERE, null, ex);
        } **/
      return list;    
    }

    @Override
    public void update(Appointment1 appointment) {
        this.delete(appointment.getId());
        this.create(appointment);
    }

    @Override
    public void delete(long appointmentId) {
        for(int i = 0; i != read().size(); i++){
            if(read().get(i).getId() == appointmentId){
                read().remove(i);
            }
        }
    }

    @Override
    public Appointment1 getAppointment(long appointmentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
