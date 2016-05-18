/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import rest.Elevation;
import org.springframework.web.client.RestTemplate;
import rest.Result;
import rest.Weather;
import rest.Current;

/**
 *
 * @author Eline
*/

public class TestRest {
    public static void main(String[] args) throws IOException{
       // RestTemplate restTemplate = new RestTemplate();
        //Weather response = restTemplate.getForObject("http://api.apixu.com/v1/current.json?key=aebe5a3f024040ff9bf112640160705&q=Brussel", Weather.class);
        //System.out.println(response.toString());
        
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper jacksonObjectMapper = new ObjectMapper();
        
        LinkedHashMap map= restTemplate.getForObject("http://api.apixu.com/v1/current.json?key=aebe5a3f024040ff9bf112640160705&q=Brussel", LinkedHashMap.class);
        Weather weatherDescription = jacksonObjectMapper.convertValue(map.get("current"), Weather.class);
        //Current weatherCondition = jacksonObjectMapper.convertValue(map.get("condition"), Current.class);

      //  Current current = restTemplate.getForObject("http://api.apixu.com/v1/current.json?key=aebe5a3f024040ff9bf112640160705&q=Brussel", Current.class);
        
        System.out.println(weatherDescription.toString());
       // System.out.println(current.getConditions().get(0).getCurrent());
    }
    
}

/**http://api.apixu.com/v1/current.json?key=aebe5a3f024040ff9bf112640160705&q=Paris**/