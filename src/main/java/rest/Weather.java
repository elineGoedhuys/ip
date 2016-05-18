/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Eline
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    
   private String temp_c;
   private String feelslike_c;

    public Weather() {
    }

    public String getTemp_c() {
        return temp_c;
    }

    public String getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(String feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public void setTemp_c(String temp_c) {
        this.temp_c = temp_c;
    }

    @Override
    public String toString() {
        return temp_c + " " + feelslike_c;
    }
   
   
    
    
}
