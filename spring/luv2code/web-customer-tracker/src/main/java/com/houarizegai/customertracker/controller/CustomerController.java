package com.houarizegai.customertracker.controller;

import com.houarizegai.customertracker.entity.Customer;
import com.houarizegai.customertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired // inject the customer service
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		// get customers from the service
		List<Customer> customers = customerService.getCustomers();

		// add customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		// for bind form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}
}
