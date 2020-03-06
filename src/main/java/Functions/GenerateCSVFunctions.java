package Functions;

import com.example.demo.location.Location;
import java.util.List;

import static Functions.RandomValuesFunctions.generateLocation;


public class GenerateCSVFunctions {
    public static List<Location> generateJSON(List<Location> locations, int size) {
        locations.clear();
        for(int i=0; i<size; i++) {
            locations.add(generateLocation());
        };
        return locations;
    }

    public static String[] generateSeparatedStrings(String unseparatedFields) {
        return unseparatedFields.replaceAll("\\s","").split(",");
    }

    public static String generateCsvRequestedFieldValues(List<Location> locations, String[] separatedRequestedFields) {
        String csv = "";
        for (String requestedField : separatedRequestedFields) {
            csv += requestedField + ",";
        }
        for (Location location : locations) {
            for(String requestedField : separatedRequestedFields) {
                try {
                    csv += location.get(requestedField);
                }catch(Exception e) {
                    System.out.println(e);
                    throw e;
                }
            }
            csv += "\n";
        }
        return csv;
    }



    public static String generateCsvFixedFields(List<Location> locations) {
        String csv = "type" + "," + "_id" + "," + "name" + "," + "latitude" + "," + "longitude" + "," + "\n";
        for (Location location : locations) {
            csv += location.get_type() + "," + location.getLocation_id() + "," + location.getName() + "," + location.getLongitude() + "," + location.getLatitude() + "\n";
        }
        return csv;
    }
}
