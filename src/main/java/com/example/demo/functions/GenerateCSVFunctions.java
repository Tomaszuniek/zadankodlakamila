package com.example.demo.functions;

import com.example.demo.location.Location;
import java.util.List;

import static com.example.demo.functions.RandomValuesFunctions.generateLocation;


public class GenerateCSVFunctions {

    private GenerateCSVFunctions(){}//?

    public static List<Location> generateJSON(List<Location> locations, int size) {
        locations.clear();
        for(int i=0; i<size; i++) {
            locations.add(generateLocation());
        }
        return locations;
    }

    public static String[] generateSeparatedStrings(String unseparatedFields) {
        return unseparatedFields.replaceAll("\\s","").split(",");
    }

    public static String generateCsvRequestedFieldValues(List<Location> locations, String[] separatedRequestedFields) throws IllegalArgumentException {
        StringBuilder builder = new StringBuilder();
        for (String requestedField : separatedRequestedFields) {
            builder.append(requestedField + ",");
        }
        for (Location location : locations) {
            for(String requestedField : separatedRequestedFields) {

                    builder.append(location.get(requestedField));

            }
             builder.append("\n");
        }
        return builder.toString();
    }



    public static String generateCsvFixedFields(List<Location> locations) {
        StringBuilder builder = new StringBuilder();
        builder.append("type" + "," + "_id" + "," + "name" + "," + "latitude" + "," + "longitude" + "," + "\n");
        for (Location location : locations) {
            builder.append(location.get_type() + "," + location.getLocation_id() + "," + location.getName() + "," + location.getLongitude() + "," + location.getLatitude() + "\n");
        }
        return builder.toString();
    }
}
