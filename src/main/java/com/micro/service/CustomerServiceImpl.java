package com.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.bean.Customer;
import com.micro.exception.CustomerNotFoundException;
import com.micro.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer getCustomer(long id) {
	 
		 Customer customer = customerRepository.findById(id)
				 	.orElseThrow(() -> new CustomerNotFoundException("Customer Not Found!!!"));
		 return customer;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer deleteCustomer(long id) {
		Customer customer = getCustomer(id);
		customerRepository.delete(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(long id, Customer customer) {
		Customer customerModified = getCustomer(id);
		customerModified.setName(customer.getName());
		customerModified.setGender(customer.getGender());
		customerModified.setUserId(customer.getUserId());
		return saveCustomer(customerModified);
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

}
