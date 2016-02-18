/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eline
 */
public class Doctor extends Person {
    
    private String doctorId;
    
    public Doctor(String firstName, String lastName, String passportId, Address address, int age, String doctorId){
        super(firstName,lastName,passportId,address,age);
        this.setDoctorId(doctorId);
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorId() {
        return doctorId;
    }
    
    
}
