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
public class Condition {
    private double current;

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }
    
    
}
