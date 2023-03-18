package com.rj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rj.model.Customer;
import com.rj.repository.CustomerRepository;

@SpringBootApplication
public class CustomerRelationshipManagerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CustomerRelationshipManagerApplication.class, args);
	}
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		Customer customer = new Customer();
//		customer.setFirstName("Rohit");
//		customer.setLastName("Jha");
//		customer.setEmailId("roj11@gmail.com");
//		customerRepository.save(customer);
//		
//		Customer customer1 = new Customer();
//		customer1.setFirstName("Avi");
//		customer1.setLastName("Kumar");
//		customer1.setEmailId("avi11@gmail.com");
//		customerRepository.save(customer1);
		
	}

}
