package com.houarizegai.jackson.json.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// ignore every json property not mentioned in this class (field).
// like say: if there is new property added in json file we need to be aware of it, and not give me an exception.
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private boolean active;
    private Address address;
    private String[] languages;

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
