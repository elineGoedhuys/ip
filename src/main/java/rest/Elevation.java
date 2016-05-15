/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;


/**
 *
 * @author Eline
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Elevation {
    private List<Result> results;

    public List<Result> getResult() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }    
}
