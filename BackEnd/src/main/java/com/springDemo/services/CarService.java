package com.springDemo.services;

import java.util.List;

import com.springDemo.RequestDtos.CarRequestDto;
import com.springDemo.RespDtos.CarResponseDto;
import com.springDemo.entities.Car;
import com.springDemo.exceptions.IncorrectDataException;

public interface CarService {

	List<CarResponseDto> getAllCars();
	
    Car addCar(CarRequestDto carInfo) throws IncorrectDataException;
	
	CarResponseDto findById(long id);
	
	Car updateCar(long id, CarRequestDto carInfo) throws IncorrectDataException;
	
	void deleteCar(long id);
	
	List<CarResponseDto> findByCity(String city) throws IncorrectDataException;
	
	List<CarResponseDto> findByLocationId(long id);
}
