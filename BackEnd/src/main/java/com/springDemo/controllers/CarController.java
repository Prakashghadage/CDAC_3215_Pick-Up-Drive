package com.springDemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.springDemo.RequestDtos.CarRequestDto;
import com.springDemo.RespDtos.CarResponseDto;
import com.springDemo.entities.Car;
import com.springDemo.exceptions.IncorrectDataException;
import com.springDemo.services.CarService;
import com.springDemo.services.LocationService;
import com.springDemo.services.ReservationService;

@RestController
@RequestMapping("/cars/")
@CrossOrigin
public class CarController {

	@Autowired
	private CarService carService;
	
	private ReservationService reservationService;
	
	private LocationService locationService;
	
	@PostMapping("/addcar")
	public ResponseEntity<Car> addCar(@Valid @RequestBody CarRequestDto carRequestDto) throws IncorrectDataException{
		Car nCar = carService.addCar(carRequestDto);
		return new ResponseEntity<>(nCar,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CarResponseDto>> getAll(){
		return new ResponseEntity<>(carService.getAllCars(),HttpStatus.OK);
	}

	@ResponseBody
    @GetMapping(value = "/getcarlocation")
    public ResponseEntity<List<CarResponseDto>> showCarLocation(@RequestParam String city) throws IncorrectDataException {
        return new ResponseEntity<>(carService.findByCity(city), HttpStatus.OK);
    }
	
    @DeleteMapping("/deletecar")
    public ResponseEntity<?> deleteCar(@RequestParam("id") long id) {
        carService.deleteCar(id);
        return new ResponseEntity(HttpStatus.OK);
    }
	
	@ResponseBody
    @GetMapping("/getcar")
    public ResponseEntity<CarResponseDto> getCar(@RequestParam("id") long id) throws IncorrectDataException {
        return new ResponseEntity(carService.findById(id), HttpStatus.OK);
    }
	
    @PutMapping("/updatecar")
    public ResponseEntity<?> editCar(@RequestParam("id") long id, @RequestBody CarRequestDto carRequestDto) throws IncorrectDataException {
        carService.updateCar(id, carRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
