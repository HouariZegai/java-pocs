package com.houarizegai.springdemo.mvc.formvalidation;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// add an initBinder (pre-process)..to convert trim input strings
	// remove loading and trailing whitespace (if String only has white space ..trim it to null)
	// resolve issue for our validation (this method called for every web request coming to the controller)
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer()); // set form..
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		System.out.println("Last name: |" + customer.getLastName() + "|");
		
		System.out.println("The binding result: " + bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "customer-form";
		} else
			return "customer-confirmation";
	}
	
}
