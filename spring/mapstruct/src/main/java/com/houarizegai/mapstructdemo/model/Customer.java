package com.houarizegai.mapstructdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author HouariZegai, created on 09/02/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private long customerId;
    private String firstname;
    private String lastname;
    private double creditScore;
    private LocalDate dateOfBirth;
}
