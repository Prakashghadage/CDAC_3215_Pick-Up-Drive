package com.springDemo.services;

import java.util.List;

import com.springDemo.RequestDtos.LocationRequestDto;
import com.springDemo.RespDtos.LocationResponseDto;

public interface LocationService {
	
	LocationResponseDto findById(long id);
	
	LocationResponseDto findByCity(String city);
	
	List<LocationResponseDto> getAllLocations();
	
	void addLocation(LocationRequestDto locationRequestDto);
	
	void deleteByCity(String city);
	

}
