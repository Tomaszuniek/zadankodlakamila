package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.location.Location;
 

import java.util.ArrayList;
import java.util.List;

import static Functions.GenerateCSVFunctions.*;


@RestController
public class JSONController {
	List<Location> locations = new ArrayList<Location>();

	@RequestMapping(value = "/generate/json/{size}")
	@ResponseBody
	public List<Location> returnJSON(
			  @PathVariable("size") int size) {
		return generateJSON(locations, size);
	}

	 @GetMapping(value = "/CsvFixedFields")
	   	public String returnCsv() {
		return generateCsvFixedFields(locations);
	 }

	 @GetMapping(value = "/csvWithRequestedFields/{requestedFields}")
	   	public String returnCsv(
	   			@PathVariable("requestedFields") String requestedFields) throws Exception{
		 return returnRequestedFieldValues(locations, generateSeparatedStrings(requestedFields));
	 }
}