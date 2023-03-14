package com.springDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springDemo.RequestDtos.LoginDto;
import com.springDemo.RespDtos.AdminRespDto;
import com.springDemo.RespDtos.UserRespDto;
import com.springDemo.services.AdminService;
import com.springDemo.services.UserService;

@RestController
@RequestMapping("pnd/login/")
@CrossOrigin
public class LoginController {

	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/")
	public ResponseEntity<UserRespDto> loginUser(@RequestBody LoginDto logindtls)
	{
		UserRespDto loggeduser=this.userService.authenticate(logindtls);
		return new ResponseEntity<>(loggeduser,HttpStatus.OK);
   	}
	
}
