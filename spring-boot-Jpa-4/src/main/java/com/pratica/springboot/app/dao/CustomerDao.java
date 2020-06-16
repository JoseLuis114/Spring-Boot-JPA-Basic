package com.pratica.springboot.app.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pratica.springboot.app.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {
	
	@Query("select c from Customer c where c.name like %?1%")
	public List<Customer> findByName(String name);
	

}
