package com.houarizegai.springcrmrest.rest;

import com.houarizegai.springcrmrest.entity.Customer;
import com.houarizegai.springcrmrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);

        if(customer == null)
            throw new CustomerNotFoundException("Customer id not found - " + customerId);

        return customer;
    }

    // for POST / customer - add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        // also just in case the pass an id in JSON ... set id to 0
        // for not do the update (because in hibernate we use saveOrUpdate() method)
        customer.setId(0); // Id of 0 means DAO code will "INSERT" new customer

        customerService.saveCustomer(customer);

        return customer;
    }

    // for PUT / customer - update existing customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }


}
