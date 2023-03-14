package com.springDemo.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springDemo.RequestDtos.ReservationReqDto;
import com.springDemo.RespDtos.ReservationRespDto;
import com.springDemo.exceptions.IncorrectDataException;
import com.springDemo.services.CarService;
import com.springDemo.services.LocationService;
import com.springDemo.services.ReservationService;
import com.springDemo.services.UserService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private UserService userService;
	@Autowired
	private CarService carService;
	@Autowired
	private LocationService locationService;
	
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
	
	@ResponseBody
	@GetMapping("/get")
	public ResponseEntity<?> getReservation(@RequestParam long id) throws IncorrectDataException{
		return new ResponseEntity(userService.getReservationUser(id),HttpStatus.OK);
	}
	
	@ResponseBody
	@PostMapping("/add")
	public ResponseEntity<?> addReservation( @RequestBody ReservationReqDto reservationReqDto) throws IOException, IncorrectDataException, ParseException{
//		System.out.println(reservationReqDto);
		reservationService.save(reservationReqDto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getReservationById(@RequestParam long id) throws IncorrectDataException{
		return new ResponseEntity(reservationService.getCurrentReservation(id),HttpStatus.OK);
	}
	
	
	
}
