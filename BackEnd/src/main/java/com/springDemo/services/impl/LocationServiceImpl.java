package com.springDemo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDemo.Repository.LocationRepo;
import com.springDemo.RequestDtos.LocationRequestDto;
import com.springDemo.RespDtos.LocationResponseDto;
import com.springDemo.entities.Location;
import com.springDemo.exceptions.ResourceNotFoundException;
import com.springDemo.services.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepo locationRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public LocationResponseDto findById(long id) {
		// TODO Auto-generated method stub
		if(this.locationRepo.existsById(id))
		{
			return locationToDto(locationRepo.findById(id).get());
		}else {
			throw new ResourceNotFoundException("No location found with this ID");
		}
	}

	@Override
	public LocationResponseDto findByCity(String city) {
		// TODO Auto-generated method stub
		if(this.locationRepo.existsByCity(city))
		{
			return locationToDto(locationRepo.findByCity(city).get());
		}
		else {
			throw new ResourceNotFoundException("No Location found with this name");
		}
	}

	@Override
	public List<LocationResponseDto> getAllLocations() {
		// TODO Auto-generated method stub
		return this.locationRepo.findAll().stream().map(loc -> locationToDto(loc)).collect(Collectors.toList());
	}

	@Override
	public void addLocation(LocationRequestDto locationRequestDto) {
		// TODO Auto-generated method stub
		this.locationRepo.save(dtoToLocation(locationRequestDto));

	}

	@Override
	public void deleteByCity(String city) {
		// TODO Auto-generated method stub
         this.locationRepo.deleteByCity(city);
	}
	
	public Location dtoToLocation(LocationRequestDto locationRequestDto)
	{
		Location location = this.modelMapper.map(locationRequestDto, Location.class);
		return location;
	}
	
	public LocationResponseDto locationToDto(Location location) {
		LocationResponseDto locationResponseDto=this.modelMapper.map(location, LocationResponseDto.class);
		return locationResponseDto;
	}
	
	

}
