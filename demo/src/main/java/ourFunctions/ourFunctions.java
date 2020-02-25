package ourFunctions;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class ourFunctions {
       
	
	//zestaw funkcji tworzacych losowe wartosci 
	public static String createString() {
		  
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
	
	public static int createInt(int limit) {
		Random random = new Random();
		return (random.nextInt(limit));
	}
	
	
	public static boolean createBool() {
		Random random = new Random();
		return (random.nextBoolean());
	}
	
	
	public static Map<String,Integer> createMap() {
		Map<String, Integer> latlon= new TreeMap<>();
		latlon.put("latitude",createInt(360));
		latlon.put("longitude",createInt(360));
		
		return (latlon);
	}	
	
	
	
	
	
}