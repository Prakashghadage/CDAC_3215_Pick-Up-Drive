package com.springDemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.NewConstructorTypeMunger;
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
import org.springframework.web.bind.annotation.RestController;

import com.springDemo.RequestDtos.ApiResponse;
import com.springDemo.RequestDtos.UserReqDto;
import com.springDemo.RespDtos.UserRespDto;
import com.springDemo.entities.User;
import com.springDemo.services.UserService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pnd/users/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/adduser")
	public ResponseEntity<?> UserRegistration(@Valid @RequestBody UserReqDto userReqDto)
	{
		userService.registerUser(userReqDto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("/{username}")
	public ResponseEntity<?> UpdateUser(@Valid @RequestBody UserReqDto userinfo, @PathVariable String username){
		userService.updateUser(userinfo, username);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") long uid){
		this.userService.deleteUser(uid);
		return new ResponseEntity( new ApiResponse("User deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserRespDto>> getAllUsers(){
		return new ResponseEntity<List<UserRespDto>>(userService.getAllUsers(),HttpStatus.OK);
	}

}
