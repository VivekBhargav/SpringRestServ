package com.task20.springMvc.dao;

import java.util.List;
import java.util.Map;

import com.task20.springMvc.pojo.Customer;


public interface ICustomerDAO {
	boolean addCustomer(Customer customer);

	boolean deleteCustomer(int customerId);

	boolean updateCustomer(Customer customer);

	Customer loadCustomer(int customerId);
	
	List<Customer> getCustomers(String zipCode); //get all customers who's in the zip code. (User Query API)

	Map<String, Double> getMonthlySales(int year); //get monthly sales in the given year.

}
