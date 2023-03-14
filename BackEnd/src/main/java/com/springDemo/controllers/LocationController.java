package com.springDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springDemo.RequestDtos.LocationRequestDto;
import com.springDemo.RespDtos.LocationResponseDto;
import com.springDemo.services.LocationService;

@RestController
@RequestMapping("/city/")
@CrossOrigin
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@ResponseBody
	@GetMapping("/show-cities")
	public ResponseEntity<List<LocationResponseDto>> showAllLocations(){
		
		return new ResponseEntity<>(locationService.getAllLocations(),HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping("/showbyid")
	public ResponseEntity<LocationResponseDto> getLocationbyId(@RequestParam long id){
		return new ResponseEntity<>(locationService.findById(id),HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping("/showbycity")
	public ResponseEntity<LocationResponseDto> getLocationByCity(@RequestParam String city){
		return new ResponseEntity<>(locationService.findByCity(city),HttpStatus.OK);
	}
	
	@ResponseBody
	@PostMapping("/addcity")
	public ResponseEntity<?> addCity(@RequestBody LocationRequestDto locationRequestDto){
		locationService.addLocation(locationRequestDto);
		return new ResponseEntity(HttpStatus.OK);
	}
}
