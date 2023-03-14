package com.springDemo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springDemo.entities.Car;

public interface CarRepo extends JpaRepository<Car, Long> {
	
	boolean existsByCid(long id);

     List<Car> findByLocationLid(long id);
	
	List<Car> findByLocationCity(String city);
	
	Optional<Car> findByCid(long id);
}
