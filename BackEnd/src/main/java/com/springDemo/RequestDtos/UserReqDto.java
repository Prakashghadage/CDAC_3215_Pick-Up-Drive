package com.springDemo.RequestDtos;


import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserReqDto {

	@Size(min=4)
	private String username;
	
	@Email
	private String email;
	
	@Size(min=3, max=30)
	private String password;
}
