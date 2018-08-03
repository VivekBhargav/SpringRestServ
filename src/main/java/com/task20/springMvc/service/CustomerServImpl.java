package com.task20.springMvc.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task20.springMvc.dao.ICustomerDAO;
import com.task20.springMvc.pojo.Customer;

@Service
public class CustomerServImpl implements CustomerServ{
	static Scanner scan = new Scanner(System.in);
	
	@Autowired
	ICustomerDAO customerDao;

	@Override
	public void getCustomers() {
		System.out.println("Enter Zip: ");
		String zip = scan.next();
		List<Customer> customers = customerDao.getCustomers(zip);
		System.out.println(customers);
	}

	@Override
	public Customer loadCustomer(int id) {
		Customer cust = customerDao.loadCustomer(id);
		return cust;
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	@Override
	public void getMonthlySales() {
		System.out.println("Enter year: ");
		int year = scan.nextInt();
		Map<String, Double> result = customerDao.getMonthlySales(year);
		result.forEach((k,v) -> System.out.println("Month = "
                + k + ", Sales = " + v));
	}
	
	@Override
	public Customer getSampleCustomer() {
		Customer customer = new Customer("Mr", "Vivek", "K", "vivek@vivek.com", "Imcs", "Vicky");
		return customer;
	}

}
