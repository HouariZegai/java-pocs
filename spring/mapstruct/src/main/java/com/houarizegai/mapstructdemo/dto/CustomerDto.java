package com.houarizegai.mapstructdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author HouariZegai, created on 09/02/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private String fullName;
    private double creditScore;
    private String dateOfBirth;
}
