package com.pratica.springboot.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratica.springboot.app.entities.Customer;
import com.pratica.springboot.app.service.CustomerService;

@RestController
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;
	
	
	// http://localhost:8080/customers (GET) 
	
	@RequestMapping(value = "/customers",method = RequestMethod.GET, produces = "application/json")
	public List<Customer> getCustomers() { 
		
		return customerService.findAllCustomers(); 
	}
	

	// http://localhost:8080/customers/1 (GET)
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, produces = "application/json")
	 public Optional<Customer> getCustomerById(@PathVariable Long id) { 
		return customerService.findCustomerById(id);
	}
	  
	// http://localhost:8080/customers/add (POST) 
	@RequestMapping(value ="/customers/add", method = RequestMethod.POST, produces = "application/json")
	 public Customer addCustomer(Customer customer) { 
		return customerService.saveCustomer(customer);
	
	 }
	// http://localhost:8080/customers/delete/1 (DELETE) 
	@RequestMapping(value = "/customers/delete/{id}", method = RequestMethod.GET,produces = "application/json") 
	public String deleteCustomer(@PathVariable Long id) { 
		return customerService.deleteCustomer(id);
	}
	
	// http://localhost:8888/customers/update (PUT)
	
	@RequestMapping(value = "/customers/update", method = RequestMethod.PATCH, produces = "application/json")		
	public String updateCustomer(Customer customerNew) {			
		return customerService.updateCustomer(customerNew);		
	}
	
	// http://localhost:8888/updatecustomer/{name} (GET)
	@RequestMapping(value = "/updatecustomer/{name}", produces = { "application/json" })
	public @ResponseBody List<Customer> cargarCliente(@PathVariable String name) {
		return customerService.findByName(name);

	}

}
