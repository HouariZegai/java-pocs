package com.houarizegai.exceldemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private boolean gender;
    private int age;
    private double salary;
}
