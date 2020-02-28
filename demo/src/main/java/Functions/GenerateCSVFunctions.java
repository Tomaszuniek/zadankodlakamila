package ourFunctions;

import com.example.demo.location.Location;
import java.util.List;
import static com.example.demo.randomvaluesfunctions.RandomValuesFunctions.generateLocation;

public class CSVGenerator {
    public static List<Location> generateJSON(List<Location> locations, int size){
        locations.clear();
        for(int i=0; i<size; i++) {
            locations.add(generateLocation());
        };
        return (locations);
    }

    public static String[] generateSeparatedStrings(String unseparatedFields){
        unseparatedFields = unseparatedFields.replaceAll("\\s","");
        String[] separatedRequestedFields = unseparatedFields.split(",");
        return separatedRequestedFields;
    }

    public static String returnRequestedFieldValues(List<Location> locations, String[] separatedRequestedFields) {
        String csv = "";
        for (String requestedField : separatedRequestedFields) {
            csv += requestedField + ",";
        }
        for (Location location : locations) {
            for(String requestedField : separatedRequestedFields) {
                csv += returnFieldValue(location, requestedField);
            }
            csv += "\n";
        }
        return csv;
    }

    public static String returnFieldValue(Location location, String requestedField) {
        switch (requestedField) {
            case "_type":
                return location.get_type() + ",";
            case "_id":
                return location.get_id() + ",";
            case "key":
                return location.getKey() + ",";
            case "name":
                return location.getName() + ",";
            case "fullName":
                return location.getFullName() + ",";
            case "iata_airport_code":
                return location.getIata_airport_code() + ",";
            case "type":
                return location.getType() + ",";
            case "country":
                return location.getCountry() + ",";
            case "geo_position":
                return location.getGeo_position() + ",";
            case "location_id":
                return location.getLocation_id() + ",";
            case "inEurope":
                return location.isInEurope() + ",";
            case "countryCode":
                return location.getCountryCode() + ",";
            case "coreCountry":
                return location.isCoreCountry() + ",";
            case "distance":
                return location.getDistance() + ",";
            case "latitude":
                return location.getLatitude() + ",";
            case "longitude":
                return location.getLongitude() + ",";
            default:
                throw new IllegalArgumentException("field does not exist");
        }
    }

    public static String generateCsvFixedFields(List<Location> locations){
        String csv = "type" + "," + "_id" + "," + "name" + "," + "latitude" + "," + "longitude" + "," + "\n";
        for (Location lokacja : locations) {
            csv += lokacja.get_type() + "," + lokacja.getLocation_id() + "," + lokacja.getName() + "," + lokacja.getLongitude() + "," + lokacja.getLatitude() + "\n";
        }
        return csv;
    }
}
