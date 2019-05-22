package com.houarizegai.springdemo.mvc.form;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	
	private Map<String, String> countryOptions;
	
	public Student() {
		// load country options from DB, file system or other. .. i'm put manual value for test
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("DZ", "Algeria");
		countryOptions.put("PL", "Palestine");
		countryOptions.put("TN", "Tunisia");
		countryOptions.put("MA", "Maroc");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Map<String, String> getCountryOptions() {
		return countryOptions;
	}
	
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + "]";
	}
	
}
