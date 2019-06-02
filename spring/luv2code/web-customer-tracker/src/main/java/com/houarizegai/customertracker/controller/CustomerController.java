package com.houarizegai.customertracker.controller;

import com.houarizegai.customertracker.dao.CustomerDAO;
import com.houarizegai.customertracker.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	@Autowired
	private CustomerDAO customerDao;

	@RequestMapping("/list")
	public String listcustomers(Model model) {
		// get customers from the dao
		List<Customer> customers = customerDao.getCustomers();

		// add customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}
	
}
