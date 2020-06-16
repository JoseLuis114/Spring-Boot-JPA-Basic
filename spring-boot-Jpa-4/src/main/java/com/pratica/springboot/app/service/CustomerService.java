package com.pratica.springboot.app.service;

import java.util.List;
import java.util.Optional;

import com.pratica.springboot.app.entities.Customer;
import com.pratica.springboot.app.entities.Vehicle;

public interface CustomerService {

	public List<Customer> findAllCustomers();

	public Optional<Customer> findCustomerById(Long id);

	public Customer saveCustomer(Customer customerNew);

	public String deleteCustomer(Long id);

	public String updateCustomer(Customer customerNew);
	
	public List<Customer> findByName(String name);
	
	public List<Vehicle> findByNameV(String name);


}
