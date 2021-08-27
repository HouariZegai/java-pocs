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
            System.out.println("\tFirst name: " + student.getFirstName());
            System.out.println("\tLast name: " + student.getLastName());
            System.out.println("\tActive: " + student.getActive());

            System.out.println("Address: ");
            Address address = student.getAddress();
            System.out.println("\tCountry: " + address.getCountry());
            System.out.println("\tCity: " + address.getCity());

            System.out.print("Languages: \n\t");
            for (String lang : student.getLanguages())
                System.out.print(lang + ", ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
