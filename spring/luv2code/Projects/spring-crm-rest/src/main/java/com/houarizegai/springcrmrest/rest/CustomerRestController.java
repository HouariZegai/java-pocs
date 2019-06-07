package com.houarizegai.springcrmrest.controller;

import com.houarizegai.springcrmrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;
}
