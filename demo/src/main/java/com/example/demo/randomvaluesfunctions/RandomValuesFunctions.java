package com.example.demo.randomvaluesfunctions;

import com.example.demo.location.Location;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RandomValuesFunctions {
	public static Location generateLocation() {
		String country = generateString();
		String name = generateString();
		return new Location(generateString(), generateInt(1000000), generateString(), name, name + ", " + country, generateString(), generateString(), country, generateMap(), generateInt(100000), generateBool(), generateString(), generateBool(), generateInt(1000000));
	}

	public static String generateString() {
		int leftLimit = 97;
	    int rightLimit = 122; 
	    Random random = new Random();
	    int targetStringLength = random.nextInt(10)+1;
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    return(generatedString);
	}
	
	public static int generateInt(int limit) {
		Random random = new Random();
		return (random.nextInt(limit));
	}

	public static boolean generateBool() {
		Random random = new Random();
		return (random.nextBoolean());
	}
	
	public static Map<String,Integer> generateMap() {
		Map<String, Integer> latlon= new TreeMap<>();
		latlon.put("latitude",generateInt(360));
		latlon.put("longitude",generateInt(360));
		return (latlon);
	}
}