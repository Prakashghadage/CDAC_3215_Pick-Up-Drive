package com.springDemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.springDemo.RequestDtos.LoginDto;
import com.springDemo.RespDtos.AdminRespDto;
import com.springDemo.RespDtos.CarResponseDto;
import com.springDemo.RespDtos.ReservationRespDto;
import com.springDemo.entities.Car;
import com.springDemo.exceptions.IncorrectDataException;
import com.springDemo.services.AdminService;
import com.springDemo.services.CarService;
import com.springDemo.services.ReservationService;
import com.springDemo.services.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/login")
	public ResponseEntity<AdminRespDto> loginAdmin(@RequestBody LoginDto logindtls){
		AdminRespDto loggedAdmin=this.adminService.authenticate(logindtls);
		return new ResponseEntity<>(loggedAdmin,HttpStatus.OK);
	}
	
	@PostMapping("/addcar")
	public ResponseEntity<Car> addCar(@Valid @RequestBody CarRequestDto carRequestDto) throws IncorrectDataException{
		Car nCar = carService.addCar(carRequestDto);
		return new ResponseEntity<>(nCar,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CarResponseDto>> getAll(){
		return new ResponseEntity<>(carService.getAllCars(),HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecar")
    public ResponseEntity<?> deleteCar(@RequestParam("id") long id) {
        carService.deleteCar(id);
        return new ResponseEntity(HttpStatus.OK);
    }
	@PutMapping("/updatecar")
    public ResponseEntity<?> editCar(@RequestParam("id") long id, @RequestBody CarRequestDto carRequestDto) throws IncorrectDataException {
        carService.updateCar(id, carRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	@ResponseBody
    @GetMapping("/getcar")
    public ResponseEntity<CarResponseDto> getCar(@RequestParam long id) throws IncorrectDataException {
        return new ResponseEntity(carService.findById(id), HttpStatus.OK);
    }
	
	@ResponseBody
	@GetMapping("/show")
	public ResponseEntity<List<ReservationRespDto>> getReservations(){
		return new ResponseEntity<>(reservationService.getAllReservations(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteReservation(@RequestParam long id){
		reservationService.deleteByRentID(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getReservationById(@RequestParam long id) throws IncorrectDataException{
		return new ResponseEntity(reservationService.getCurrentReservation(id),HttpStatus.OK);
	}
}
