package com.springDemo.services;

import java.util.List;
import java.util.Optional;

import com.springDemo.RequestDtos.LoginDto;
import com.springDemo.RequestDtos.UserReqDto;
import com.springDemo.RespDtos.ReservationRespDto;
import com.springDemo.RespDtos.UserRespDto;
import com.springDemo.entities.User;
import com.springDemo.exceptions.IncorrectDataException;


public interface UserService {

	Optional<User> findByName(String Name) throws IncorrectDataException;
	
	UserRespDto findByEmail(String email);
	
void registerUser(UserReqDto userinfo);

UserRespDto authenticate(LoginDto loginInfo);
	
	List<UserRespDto> getAllUsers();
	
	void deleteUser(long id);
	
	void updateUser(UserReqDto userinfo, String username);
	
	List<ReservationRespDto> getReservationUser(long id) throws IncorrectDataException;
	
}
