package com.houarizegai.springcrmrest.rest;

import com.houarizegai.springcrmrest.entity.Customer;
import com.houarizegai.springcrmrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    private List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

}
