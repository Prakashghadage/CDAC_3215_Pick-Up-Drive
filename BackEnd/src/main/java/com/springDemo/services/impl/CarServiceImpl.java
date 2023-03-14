package com.springDemo.services.impl;

import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDemo.Repository.CarRepo;
import com.springDemo.Repository.LocationRepo;
import com.springDemo.RequestDtos.CarRequestDto;
import com.springDemo.RespDtos.CarResponseDto;
import com.springDemo.entities.Car;
import com.springDemo.entities.Location;
import com.springDemo.exceptions.IncorrectDataException;
import com.springDemo.exceptions.ResourceNotFoundException;
import com.springDemo.services.CarService;

import io.github.classgraph.ResourceList.ByteArrayConsumerThrowsIOException;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepo carRepo;
	
	@Autowired
	private LocationRepo locationRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CarResponseDto> getAllCars() {
		// TODO Auto-generated method stub
		return carRepo.findAll().stream().map(car -> cartoDto(car)).collect(Collectors.toList());
	}
    

	@Override
	public Car addCar(CarRequestDto carInfo) throws IncorrectDataException {
		// TODO Auto-generated method stub
		if(!locationRepo.existsByCity(carInfo.getCity())) {
			throw new IncorrectDataException("Wrong location!!");
		}
		Location location=locationRepo.findByCity(carInfo.getCity()).get();
		Car car=dtotoCar(carInfo);
		car.setLocation(location);
		return this.carRepo.save(car);
	}

	@Override
	public CarResponseDto findById(long id) {
		// TODO Auto-generated method stub
		if(this.carRepo.existsById(id)) {
			return cartoDto(carRepo.findById(id).get());
		}else {
			throw new ResourceNotFoundException("No car exists by this ID");
		}
	}

	@Override
	public Car updateCar(long id, CarRequestDto carInfo) throws IncorrectDataException {
		// TODO Auto-generated method stub
		if(this.carRepo.existsById(id)) {
			Car car=carRepo.findById(id).get();
			car=update(car, carInfo);
			car.setLocation(locationRepo.findByCity(carInfo.getCity()).get());
			return carRepo.save(car);
		}else {
			throw new IncorrectDataException("Invalid Information");
		}
		
	}
	
	@Override
	public void deleteCar(long id) {
		// TODO Auto-generated method stub
		if(carRepo.existsById(id)) {
			carRepo.deleteById(id);
		}else {
			throw new ResourceNotFoundException("No car exists by this Id");
		}
		
	}
	
	public Car dtotoCar(CarRequestDto carRequestDto)
	{
		Car car=this.modelMapper.map(carRequestDto, Car.class);
		return car;
	}
	
	public CarResponseDto cartoDto(Car car) {
		CarResponseDto carResponseDto=this.modelMapper.map(car, CarResponseDto.class);
		return carResponseDto;
	}
	
	public Car update(Car car, CarRequestDto carRequestDto) {
		car.setBrand(carRequestDto.getBrand());
		car.setModel(carRequestDto.getModel());
		car.setColor(carRequestDto.getColor());
		car.setCategory(com.springDemo.entities.Category.valueOf(carRequestDto.getCategory()));
		car.setProductionYear(carRequestDto.getProductionYear());
		car.setImage(carRequestDto.getImage());
		car.setRate(carRequestDto.getRate());
		return car;
	}


	@Override
	public List<CarResponseDto> findByCity(String city) throws IncorrectDataException {
		// TODO Auto-generated method stub
		if(locationRepo.existsByCity(city)) {
			return carRepo.findByLocationCity(city).stream().map(car -> cartoDto(car)).collect(Collectors.toList());
		}
		else {
			throw new IncorrectDataException("Invalid City");
		}
	}


	@Override
	public List<CarResponseDto> findByLocationId(long id) {
		// TODO Auto-generated method stub
		return carRepo.findByLocationLid(id).stream().map(car -> cartoDto(car)).collect(Collectors.toList());
	}


	

	
}
