/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Eline
 */
public class RestWeather {
    
    RestTemplate restTemplate;
    ObjectMapper jacksonObjectMapper;
    
    LinkedHashMap map;
    Weather weatherDescription;
    public RestWeather(){
        
    }
    
    public String getWeather(){
        restTemplate = new RestTemplate();
        jacksonObjectMapper = new ObjectMapper();
        map = restTemplate.getForObject("http://api.apixu.com/v1/current.json?key=aebe5a3f024040ff9bf112640160705&q=Brussel", LinkedHashMap.class);
        weatherDescription = jacksonObjectMapper.convertValue(map.get("current"), Weather.class);
        return weatherDescription.getTemp_c();
    }
}
