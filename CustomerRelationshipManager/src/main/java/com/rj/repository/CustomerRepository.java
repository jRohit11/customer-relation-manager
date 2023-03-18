package com.rj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rj.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	

}
