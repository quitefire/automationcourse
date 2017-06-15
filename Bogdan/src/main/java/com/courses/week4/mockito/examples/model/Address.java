package com.courses.week4.mockito.examples.model;

public class Address {

	private String streetName;
	private String houseNo;
	private Country country;

	public Address(String streetName, String houseNo, Country country) {
		this.streetName = streetName;
		this.houseNo = houseNo;
		this.country = country;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
