package com.springDemo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springDemo.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long>{

	Optional<Admin> findByEmailAndPassword(String email, String password);
}
