package com.task20.springMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.task20.springMvc.pojo.Customer;
import com.task20.springMvc.service.CustomerServ;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServ custServ;

	@ModelAttribute("customer")
	public Customer construct() {
		return new Customer();
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView addCustomer() {
		return new ModelAndView("addCustomer");
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ModelAndView addedCustomer(@ModelAttribute("customer") Customer customer) {
		custServ.addCustomer(customer);
		ModelAndView mv = new ModelAndView("success");
		return mv;
	}

	@RequestMapping(value = "/delCustomer", method = RequestMethod.GET)
	public ModelAndView deleteCustomer() {
		return new ModelAndView("/delCustomer");
	}

	@RequestMapping(value = "/delCustomer/{id}", method = RequestMethod.POST)
	public ModelAndView deletedCustomer(@RequestParam("id") int custId) {
		Customer cust = custServ.loadCustomer(custId);
		if (cust == null) {
			return new ModelAndView("error");
		} else
			custServ.deleteCustomer(custId);
		return new ModelAndView("success");
	}

	@RequestMapping(value = "/updCustomer", method = RequestMethod.GET)
	public ModelAndView updateCustomer() {
		return new ModelAndView("updCustomer");
	}

	@RequestMapping(value = "/updCustomer", method = RequestMethod.POST)
	public ModelAndView updatedCustomer(@ModelAttribute("customer") Customer customer) {
		Customer cust = custServ.loadCustomer(customer.getCustID());
		if (cust == null) {
			return new ModelAndView("error");
		} else {
			custServ.updateCustomer(customer);
			ModelAndView mv = new ModelAndView("/success");
			mv.addObject("cust", customer);
			return mv;
	}
	}

	@RequestMapping(value = "/loadCustomer", method = RequestMethod.GET)
	public ModelAndView loadCustomer() {
		return new ModelAndView("loadCustomer");
	}
	
	@RequestMapping(value = "loadCustomer/{id}", method = RequestMethod.POST)
	public ModelAndView loadedCustomer(@RequestParam("id") int custId) {
		Customer customer = custServ.loadCustomer(custId);
		if(customer==null) {
			return new ModelAndView("error");
		}
		else {
			ModelAndView mv = new ModelAndView("success");
			mv.addObject("cust", customer);
			return mv;
		}
		
	}

}
