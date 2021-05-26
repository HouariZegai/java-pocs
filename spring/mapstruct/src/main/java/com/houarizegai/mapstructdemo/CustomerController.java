package com.houarizegai.mapstructdemo;

import com.houarizegai.mapstructdemo.dto.CustomerDto;
import com.houarizegai.mapstructdemo.mapper.CustomerMapper;
import com.houarizegai.mapstructdemo.mapper.CustomerMapperImpl;
import com.houarizegai.mapstructdemo.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @author HouariZegai, created on 09/02/2021
 */
@RestController
public class CustomerController {

    private final CustomerMapper customerMapper;

    public CustomerController() {
        this.customerMapper = new CustomerMapperImpl();
    }

    @GetMapping("/customer")
    public ResponseEntity<CustomerDto> getCustomer() {
        Customer customer = new Customer(1, "Houari", "Zegai", 120.0,
                LocalDate.now());
        return ResponseEntity.ok(customerMapper.toCustomerDao(customer));
    }
}
