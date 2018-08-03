package com.task20.springMvc.service;

import com.task20.springMvc.pojo.Customer;

public interface CustomerServ {
	void addCustomer(Customer customer);
	void deleteCustomer(int id);
	void updateCustomer(Customer customer);
	Customer loadCustomer(int id);
	void getCustomers();
	void getMonthlySales();
	Customer getSampleCustomer();
}
