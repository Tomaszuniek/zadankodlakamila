package com.example.demo.location;

import java.util.Map;

public class Location {
	private String name;
	private String _type;
	private int _id;
	private String key;
	private String fullName;
	private String iata_airport_code;
	private String type;
	private String country;
	private Map<String, Integer> geo_position;
	private int location_id;
	private boolean inEurope;
	private String countryCode;
	private boolean coreCountry;
	private Integer distance;
	
	public Location(String _type, int _id, String key, String name, String fullName,
			String iata_airport_code, String type, String country, Map<String, Integer> geo_position, int location_id,
			boolean inEurope, String countryCode, boolean coreCountry, Integer distance) {
		super();
		this.name = name;
		this._type = _type;
		this._id = _id;
		this.key = key;
		this.fullName = fullName;
		this.iata_airport_code = iata_airport_code;
		this.type = type;
		this.country = country;
		this.geo_position = geo_position;
		this.location_id = location_id;
		this.inEurope = inEurope;
		this.countryCode = countryCode;
		this.coreCountry = coreCountry;
		this.distance = distance;
	}



	public String get(String requestedField) {
		switch (requestedField) {
			case "_type":
				return get_type() + ",";
			case "_id":
				return get_id() + ",";
			case "key":
				return getKey() + ",";
			case "name":
				return getName() + ",";
			case "fullName":
				return getFullName() + ",";
			case "iata_airport_code":
				return getIata_airport_code() + ",";
			case "type":
				return getType() + ",";
			case "country":
				return getCountry() + ",";
			case "geo_position":
				return getGeo_position() + ",";
			case "location_id":
				return getLocation_id() + ",";
			case "inEurope":
				return isInEurope() + ",";
			case "countryCode":
				return getCountryCode() + ",";
			case "coreCountry":
				return isCoreCountry() + ",";
			case "distance":
				return getDistance() + ",";
			case "latitude":
				return getLatitude() + ",";
			case "longitude":
				return getLongitude() + ",";
			default:
				throw new IllegalArgumentException("field does not exist");
		}
	}

	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIata_airport_code() {
		return iata_airport_code;
	}
	public void setIata_airport_code(String iata_airport_code) {
		this.iata_airport_code = iata_airport_code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Map<String, Integer> getGeo_position() {
		return geo_position;
	}
	public void setGeo_position(Map<String, Integer> geo_position) {
		this.geo_position = geo_position;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public boolean isInEurope() {
		return inEurope;
	}
	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public boolean isCoreCountry() {
		return coreCountry;
	}
	public void setCoreCountry(boolean coreCountry) {
		this.coreCountry = coreCountry;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLatitude() {
		return geo_position.get("latitude");
	}
	public Integer getLongitude() {
		return geo_position.get("longitude");
	}
}

