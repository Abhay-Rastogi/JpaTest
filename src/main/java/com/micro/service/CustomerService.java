package com.micro.service;

import java.util.List;

import com.micro.bean.Customer;

public interface CustomerService {
	public Customer getCustomer(long id);
	public List<Customer> getAllCustomer();
	Customer updateCustomer(long id, Customer customer);
	Customer saveCustomer(Customer customer);
	Customer deleteCustomer(long id);
}
