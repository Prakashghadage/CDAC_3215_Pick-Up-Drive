package com.springDemo.RespDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRespDto {

	private long uid;
	
	private String username;
	
	private String email;
	
	private String password;
}
