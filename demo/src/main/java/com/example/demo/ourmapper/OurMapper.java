package com.example.demo.ourmapper;



import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.demo.location.Location;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OurMapper {
	
	public static Location[] getCsv(URL url) {
		
	
	ObjectMapper objectMapper = new ObjectMapper();
	Location[] locations;
	try {
	
	
	
	locations = objectMapper.readValue(url, Location[].class);
	return(locations);
	
	
	}catch(MalformedURLException e){
		
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
	
}
