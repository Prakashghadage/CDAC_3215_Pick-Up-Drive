package com.springDemo.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDemo.Repository.CarRepo;
import com.springDemo.Repository.LocationRepo;
import com.springDemo.Repository.ReservationRepo;
import com.springDemo.Repository.UserRepo;
import com.springDemo.RequestDtos.ReservationReqDto;
import com.springDemo.RespDtos.ReservationRespDto;
import com.springDemo.entities.Car;
import com.springDemo.entities.Location;
import com.springDemo.entities.Reservation;
import com.springDemo.entities.User;
import com.springDemo.exceptions.IncorrectDataException;
import com.springDemo.services.ReservationService;

import io.jsonwebtoken.lang.Collections;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepo reservationRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CarRepo carRepo;
	@Autowired
	private LocationRepo locationRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ReservationRespDto getResvByRentId(long id) {
		// TODO Auto-generated method stub
		return reservationToDto(reservationRepo.findById(id).get());
	}

	@Override
	public void deleteByRentID(long id) {
		// TODO Auto-generated method stub
		this.reservationRepo.deleteById(id);
		
	}

	@Override
	public List<ReservationRespDto> getCurrentReservation(long id) throws IncorrectDataException {
		// TODO Auto-generated method stub
		if(userRepo.existsById(id)) {
			return reservationRepo.findCurrent(id).stream().map(reservation -> reservationToDto(reservation)).collect(Collectors.toList());
		}
		else {
			throw new IncorrectDataException("User does not exist!!");
		}
	}

	@Override
	public List<ReservationRespDto> getAllReservations() {
		// TODO Auto-generated method stub
		return reservationRepo.findAll().stream().map(reservation -> reservationToDto(reservation)).collect(Collectors.toList());
	}

	@Override
	public List<ReservationRespDto> findByCarID(long id) {
		// TODO Auto-generated method stub
		return reservationRepo.findByCarCid(id).stream().map(reservation -> reservationToDto(reservation)).collect(Collectors.toList());
	}

	@Override
	public ReservationRespDto save(ReservationReqDto reservationReqDto) throws IncorrectDataException, ParseException {

		System.out.println("in addReservation--->" + reservationReqDto);
		
		if(!carRepo.existsByCid(reservationReqDto.getCid())) {
			throw new IncorrectDataException("Car does not exist!!");
		}
		if(!userRepo.existsByUid(reservationReqDto.getUid())) {
			throw new IncorrectDataException("User does not exist!!");
		}
		if(!locationRepo.existsByCity(reservationReqDto.getPickupLocation())) {
			throw new IncorrectDataException("Location does not exist!!");
		}
		if(!locationRepo.existsByCity(reservationReqDto.getDropLocation())) {
			throw new IncorrectDataException("Location does not exist!!");
		}
		else {
			System.out.println("In Else of AddReservation");
			User user=userRepo.findByUid(reservationReqDto.getUid()).get();
			Car car= carRepo.findByCid(reservationReqDto.getCid()).get();
			Location startLocation=locationRepo.findByCity(reservationReqDto.getPickupLocation()).get();
			Location endLocation=locationRepo.findByCity(reservationReqDto.getDropLocation()).get();
			System.out.println("in here");
			Date startDate=new SimpleDateFormat("yyyy-MM-dd").parse(reservationReqDto.getStartDate());
			Date endDate=new SimpleDateFormat("yyyy-MM-dd").parse(reservationReqDto.getEndDate());
			long diff= endDate.getTime()-startDate.getTime();
			long noOfDays=diff / (24 * 60 * 60 * 1000);
			System.out.println("This is the reservation object "+noOfDays);
			Reservation reservation=new Reservation(car, user, startDate, endDate, startLocation, endLocation, noOfDays*(car.getRate()));
		
			reservationRepo.save(reservation);
			user.setReservations(reservation);
			userRepo.save(user);
			
			return reservationToDto(reservation);
			
		}
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
