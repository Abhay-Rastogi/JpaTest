package com.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.bean.Customer;
import com.micro.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
		Customer customer = customerService.getCustomer(id);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> customers = customerService.getAllCustomer();
		return ResponseEntity.ok(customers);
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		Customer createdCustomer = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(createdCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping(path = "delete/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable long id){
		Customer deletedCustomer = customerService.deleteCustomer(id);
		return new ResponseEntity<Customer>(deletedCustomer,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id,@RequestBody Customer customer){
		Customer updatedCustomer = customerService.updateCustomer(id,customer);
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.ACCEPTED);
	}
	
}
