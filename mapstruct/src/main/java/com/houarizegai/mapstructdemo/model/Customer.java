package com.houarizegai.mapstructdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author HouariZegai, created on 09/02/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private long customerId;
    private String firstname;
    private String lastname;
    private double creditScore;
    private LocalDate dateOfBirth;
}
