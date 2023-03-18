package com.rj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.exception.ResourceNotFoundException;
import com.rj.model.Customer;
import com.rj.repository.CustomerRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	//create customer rest api
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	//get customer by id rest api
	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " +id));
		return ResponseEntity.ok(customer);
	}
	
	//update customer rest api
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id,@RequestBody Customer customerDetails){
		Customer updateCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customr not exist with id: " +id));
		
		updateCustomer.setFirstName(customerDetails.getFirstName());
		updateCustomer.setLastName(customerDetails.getLastName());
		updateCustomer.setEmailId(customerDetails.getEmailId());
		
		customerRepository.save(updateCustomer);
		return ResponseEntity.ok(updateCustomer);
	}
	
	//delete customer rest api
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable long id){
		
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " +id));
		
		customerRepository.delete(customer);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
