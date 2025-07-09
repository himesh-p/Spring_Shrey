package com.himesh.data.service;

import java.util.List;
import java.util.Optional;

import com.himesh.data.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	public Optional<Customer> getCustomerById(Long id);
	Customer saveCustomer(Customer customer);
	void deleteCustomer(Long id);
}
