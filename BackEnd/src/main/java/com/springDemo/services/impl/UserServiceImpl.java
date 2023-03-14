package com.springDemo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDemo.Repository.ReservationRepo;
import com.springDemo.Repository.UserRepo;
import com.springDemo.RequestDtos.LoginDto;
import com.springDemo.RequestDtos.ReservationReqDto;
import com.springDemo.RequestDtos.UserReqDto;
import com.springDemo.RespDtos.ReservationRespDto;
import com.springDemo.RespDtos.UserRespDto;
import com.springDemo.entities.Reservation;
import com.springDemo.entities.User;
import com.springDemo.exceptions.DuplicateCredException;
import com.springDemo.exceptions.IncorrectDataException;
import com.springDemo.exceptions.ResourceNotFoundException;
import com.springDemo.services.UserService;

import io.github.classgraph.ResourceList.ByteArrayConsumerThrowsIOException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ReservationRepo reservationRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	

	
	

	

//	@Override
//	public UserRespDto authenticate(LoginDto loginInfo) {
//		// TODO Auto-generated method stub
//		User user=this.userRepo.findByUsernameAndPassword(loginInfo.getUsername(), loginInfo.getPassword()).orElseThrow(()-> new ResourceNotFoundException("Incorrect username and password"));
//		return user;
//	}

	@Override
	public Optional<User> findByName(String Name) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(Name);
	}



	@Override
	public UserRespDto findByEmail(String email) {
		// TODO Auto-generated method stub
		return usertoDto(userRepo.findByEmail(email).get());
	}

	@Override
	public void registerUser(UserReqDto userinfo) {
		// TODO Auto-generated method stub
		User user=dtoToUser(userinfo);
		userRepo.save(user);
	}

	@Override
	public UserRespDto authenticate(LoginDto loginInfo) {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmailAndPassword(loginInfo.getEmail(),loginInfo.getPassword()).get();
		return usertoDto(user);
	}

	@Override
	public List<UserRespDto> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll().stream().map(user -> usertoDto(user)).collect(Collectors.toList());
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		if(userRepo.existsById(id)) {
			userRepo.deleteById(id);
		}else {
			throw new ResourceNotFoundException("User with this id doesn't exist!!");
		}
	}

	@Override
	public void updateUser(UserReqDto userinfo, String username) {
		// TODO Auto-generated method stub
		if(userRepo.existsByUsername(username)) {
			User user=userRepo.findByUsername(username).get();
			user=update(user, userinfo);
			userRepo.save(user);
		}else {
			throw new ResourceNotFoundException("No User found with this username");
		}
		
		
	}

	@Override
	public List<ReservationRespDto> getReservationUser(long id) throws IncorrectDataException {
		// TODO Auto-generated method stub
		if(!reservationRepo.existsById(id)) {
			throw new IncorrectDataException("Reservation does not exist!!!");
		}else {
			if(!userRepo.existsById(id)) {
				throw new IncorrectDataException("User does not exist");
			}else {
				List<ReservationRespDto> reservations = userRepo.getReservationUser(id).stream().map(reservation -> reservationToDto(reservation)).collect(Collectors.toList());
				return reservations;
			}
		}
	}
	
	public UserRespDto usertoDto(User user) {
		UserRespDto userRespDto=this.modelMapper.map(user, UserRespDto.class);
		return userRespDto;
	}
	
	public User dtoToUser(UserReqDto userReqDto) {
		User user=this.modelMapper.map(userReqDto, User.class);
		return user;
	}

	public User update(User user, UserReqDto userReqDto) {
		user.setEmail(userReqDto.getEmail());
		user.setUsername(userReqDto.getUsername());
		user.setPassword(userReqDto.getPassword());
		return user;
	}
	public Reservation dtotoReservation(ReservationReqDto reservationReqDto)
	{
		return this.modelMapper.map(reservationReqDto, Reservation.class);
	}
	
	public ReservationRespDto reservationToDto(Reservation reservation)
	{
		return this.modelMapper.map(reservation, ReservationRespDto.class);
	}

}
