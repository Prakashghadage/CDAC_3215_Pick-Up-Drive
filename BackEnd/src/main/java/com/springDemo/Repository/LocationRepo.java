package com.springDemo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springDemo.entities.Location;

public interface LocationRepo extends JpaRepository<Location, Long>{

	Optional<Location> findByCity(String city);
	
	boolean existsByCity(String city);
	
	void deleteByCity(String city);
	
}
