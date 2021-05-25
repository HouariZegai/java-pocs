package com.houarizegai.mapstructdemo.dto;

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
public class CustomerDto {
    private String fullName;
    private double creditScore;
    private String dateOfBirth;
}
