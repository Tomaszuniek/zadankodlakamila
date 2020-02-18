package com.example.demo.controller;
import java.lang.reflect.Field; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.location.Location;
import com.example.demo.ourmapper.OurMapper;


import ourFunctions.ourFunctions;


import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

	List<Location> lista = new ArrayList<Location>();
	
	
	@RequestMapping(
			value = "/generate/json/{size}") //adres ze zmienna
	@ResponseBody
	public List<Location> getJSON( //przekazujemy zmienna
			  @PathVariable("size") int size) {
		for(int i=0; i<size; i++) { //tyle razy ile chcemy jsonow nasz kod jest
									//wykonywany
			String country = ourFunctions.createString(); //to funckja tworzaca losowy string. sa tez tworzace losowe inty i losowe boole
			String name = ourFunctions.createString(); //stworzylem te zmienne
					//osobno zeby polaczyc je w fullname jako ze to ich zlaczenie
			//nizej tworzymy nowa instancje klasy lokalizacja i wrzucamy do listy ktora zostanie zwrocona jako json
			lista.add(new Location(ourFunctions.createString(),ourFunctions.createInt(1000000),ourFunctions.createString(),name,name + ", " + country,ourFunctions.createString(),ourFunctions.createString(),country,ourFunctions.createMap(),ourFunctions.createInt(100000),ourFunctions.createBool(),ourFunctions.createString(),ourFunctions.createBool(),ourFunctions.createInt(1000000)));
		};
		return (lista);
	}
	
	
	 @GetMapping(value = "/endpoint1")
	   	public String getText() {
		 //oto naglowek naszego csv, pierwsza linia wskazuje jaki typ danych zostanie zwrocony
		 String csv = "type " + "\t" + "_id " + "\t" + "name" + "\t" + "latitude" + "\t" + "longitude";
		 
		 
		 //dla kazdej lokacji znajdujacej sie w liscie popbieramy dane jakie sa wskazane w zadaniu
		 for (Location loc : lista) {
	            csv += "\n" + loc.get_type() + " " + loc.getLocation_id() + " " + loc.getName() + " " + loc.getLongitude() + " " + loc.getLongitude();
	            
	     }
		 
		 return csv;
	 }
	
	 @GetMapping(value = "/endpoint2/{polecenia}") //adres ze zmienna
	   	public String getText2(
	   			@PathVariable("polecenia") String polecenia) {
		 
		 String[] polecenia2 = polecenia.split(","); //z racji ze polecenia mialy byc w formacie
		 											// id, name, country mozemy podzielic argument w linku na liste stringow wg przecinkow
		 String csv2 = "";
		 
		 
		 //tworzymy naglowek, wypisujemy kazda nazwe zmiennej z listy polecen np id, fullname
		 for (String a : polecenia2) {
	            csv2 += a + "\t";
	     }
		 
		 //Field[] fields = Location.class.getFields(); 
		 
		 
		 
		 //dla kazdego obiektu w liscie iterujemy przez pola klasy. jesli nazwa jest w poleceniu, dodajemy ja do danej linijki stringa
		 for (Location locc : lista) {
			 
			 for(String b : polecenia2) {
			    switch(b) {
			    	case "_type":
			    		csv2 += locc.get_type() + "\t";
			    		break;
			    	case "_id":
			    		csv2 += locc.get_id() + "\t";
			    		break;
			    	case "key":
			    		csv2 += locc.getKey() + "\t";
			    		break;
			    	case "name":
			    		csv2 += locc.getName() + "\t";
			    		break;
			    	case "fullName":
			    		csv2 += locc.getFullName() + "\t";
			    		break;
			    	case "iata_airport_code":
			    		csv2 += locc.getIata_airport_code() + "\t";
			    		break;
			    	case "type":
			    		csv2 += locc.getType() + "\t";
			    		break;
			    	case "country":
			    		csv2 += locc.getCountry() + "\t";
			    		break;
			    	case "geo_position":
			    		csv2 += locc.getGeo_position() + "\t";
			    		break;
			    	case "location_id":
			    		csv2 += locc.getLocation_id() + "\t";
			    		break;
			    	case "inEurope":
			    		csv2 += locc.isInEurope() + "\t";
			    		break;
			    	case "countryCode":
			    		csv2 += locc.getCountryCode() + "\t";
			    		break;
			    	case "coreCountry":
			    		csv2 += locc.isCoreCountry() + "\t";
			    		break;
			    	case "distance":
			    		csv2 += locc.getDistance() + "\t";
			    		break;
			    	case "latitude":
			    		csv2 += locc.getLatitude() + "\t";
			    		break;
			    	case "longitude":
			    		csv2 += locc.getLongitude() + "\t";
			    		break;
			    }
			 }
			 
			 csv2 += "\n";
		 }
		 
	     /*   for (String a : polecenia2) {
	            System.out.println(a); 
	    } */
		 
		 return csv2;
	 }
	 
}
