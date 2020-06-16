package com.pratica.springboot.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pratica.springboot.app.entities.Vehicle;

public interface VehicleDao  extends JpaRepository<Vehicle, Long>{
	
	@Query("select v from Vehicle v where v.name like %?1%")
	public List<Vehicle> findByName(String term);

}
