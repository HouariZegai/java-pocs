package com.houarizegai.mapstructdemo.mapper;

import com.houarizegai.mapstructdemo.dto.CustomerDto;
import com.houarizegai.mapstructdemo.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMapper {

    @Mapping(target = "fullName", expression = "java(customer.getFirstname() + \" \" + customer.getLastname())")
    @Mapping(target = "dateOfBirth", dateFormat = "dd.MM.yyyy")
    CustomerDto customerToDao(Customer customer);
}
