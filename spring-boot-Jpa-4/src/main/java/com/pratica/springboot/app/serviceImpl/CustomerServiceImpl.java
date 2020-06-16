package com.pratica.springboot.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pratica.springboot.app.dao.CustomerDao;
import com.pratica.springboot.app.dao.VehicleDao;
import com.pratica.springboot.app.entities.Customer;
import com.pratica.springboot.app.entities.Vehicle;
import com.pratica.springboot.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerRepository;
	
	@Autowired
	VehicleDao vehicleRepository;

	@Transactional(readOnly = true)
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Customer> findCustomerById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer;
	}
	
	@Transactional
	public Customer saveCustomer(Customer customerNew) {
		if (customerNew != null) {
			return customerRepository.save(customerNew);
		}
		return new Customer();
	}

	@Transactional
	public String deleteCustomer(Long id) {
		if (customerRepository.findById(id).isPresent()) {
			customerRepository.deleteById(id);
			return "Customer eliminado correctamente.";
		}
		return "Error! El customer no existe";
	}

	@Transactional
	public String updateCustomer(Customer customerUpdated) {
		Long num = customerUpdated.getId();
		if (customerRepository.findById(num).isPresent()) {
			Customer customerToUpdate = new Customer();
			customerToUpdate.setId(customerUpdated.getId());
			customerToUpdate.setName(customerUpdated.getName());
			customerToUpdate.setSurname(customerUpdated.getSurname());
			customerToUpdate.setBirtdate(customerUpdated.getBirtdate());
			customerRepository.save(customerToUpdate);
			return "Customer modificado";
		}
		return "Error al modificar el Customer";
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByName("%" + name + "%");
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vehicle> findByNameV(String name) {
		// TODO Auto-generated method stub
		return vehicleRepository.findByName("%" + name + "%");
	}
	
	

}
