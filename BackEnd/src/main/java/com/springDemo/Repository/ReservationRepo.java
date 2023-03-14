package com.springDemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springDemo.entities.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Long>{

	
//	 boolean existsByCarCid(long id);
	
	@Query("SELECT r FROM Reservation r WHERE r.user.uid =:id and r.endDate >= CURRENT_TIMESTAMP ")
    List<Reservation> findCurrent(@Param("id") long id);
	
	List<Reservation> findByCarCid(long id);
}
