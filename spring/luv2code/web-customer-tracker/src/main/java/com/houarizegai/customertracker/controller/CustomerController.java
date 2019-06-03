package com.houarizegai.customertracker.controller;

import com.houarizegai.customertracker.dao.CustomerDAO;
import com.houarizegai.customertracker.entity.Customer;
import com.houarizegai.customertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired // inject the customer service
	private CustomerService customerService;

	@GetMapping("/list")
	public String listcustomers(Model model) {
		// get customers from the service
		List<Customer> customers = customerService.getCustomers();

		// add customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}

}
