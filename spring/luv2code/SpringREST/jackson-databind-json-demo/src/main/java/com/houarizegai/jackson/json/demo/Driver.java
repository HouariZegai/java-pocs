package com.houarizegai.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Driver {

    public static void main(String[] args) {

        try {
            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read the JSON file and converted to Java POJO
            Student student = mapper.readValue(Driver.class.getResourceAsStream("/json/sample-full.json"), Student.class);

            // print the information
            System.out.println("Student information:");
            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());
            System.out.println("active: " + student.getActive());

            Address address = student.getAddress();
            System.out.println("Country: " + address.getCountry());
            System.out.println("city: " + address.getCity());

            System.out.println("Language[0]: " + student.getLanguages()[0]);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
