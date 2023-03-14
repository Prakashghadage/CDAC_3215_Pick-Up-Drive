package com.springDemo.RequestDtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
public class LoginDto {

	private String email;
	
	private String password;
}
