package com.atmlocator.atm.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AtmLocationDetails {
	
	private Address address;
	private GeoLocation geoLocation;
	private int distance;
	private List<OpeningHours> openingHours;
	private String functionality;
	private String type;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public List<OpeningHours> getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(List<OpeningHours> openingHours) {
		this.openingHours = openingHours;
	}
	public String getFunctionality() {
		return functionality;
	}
	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@JsonIgnore
	public String getCountryCD() {
		return this.getAddress().getCity();
	}
	
}
