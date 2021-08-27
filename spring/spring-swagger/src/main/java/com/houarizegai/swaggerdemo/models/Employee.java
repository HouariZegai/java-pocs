package com.houarizegai.swaggerdemo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author HouariZegai, created on 25/05/2021
 */
@Getter
@Setter
@AllArgsConstructor
public class Employee {

    private long id;
    private String name;
    private double salary;
}
