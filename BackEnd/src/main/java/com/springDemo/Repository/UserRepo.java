package com.springDemo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springDemo.entities.Reservation;
import com.springDemo.entities.User;




public interface UserRepo extends JpaRepository<User, Long>{

 Optional<User> findByUsername(String username);
 
 boolean existsByUid(long id);
 
 Optional<User> findByUid(long id);
 
 boolean existsByEmail(String email);
 
 boolean existsByUsername(String username);
 
Optional<User> findByEmail(String email);
 
 Optional<User> findByEmailAndPassword(String email, String password);
 
 User findByReservationsRid(long id);
 
 @Query("SELECT r FROM Reservation r WHERE r.user.uid=:id")
 List<Reservation> getReservationUser(@Param("id") long id);
 
}
