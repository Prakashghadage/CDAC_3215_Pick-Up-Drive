package com.springDemo.services;

import java.text.ParseException;
import java.util.List;

import com.springDemo.RequestDtos.ReservationReqDto;
import com.springDemo.RespDtos.ReservationRespDto;
import com.springDemo.entities.Reservation;
import com.springDemo.exceptions.IncorrectDataException;

public interface ReservationService {

	ReservationRespDto getResvByRentId(long id);
	
	void deleteByRentID(long id);
	
	//Here parameter id will be user id since one user can have many reservations
	List<ReservationRespDto> getCurrentReservation(long id) throws IncorrectDataException;
	
	List<ReservationRespDto> getAllReservations();

	List<ReservationRespDto> findByCarID(long id);
	
	ReservationRespDto save(ReservationReqDto reservationReqDto) throws IncorrectDataException, ParseException;
}
