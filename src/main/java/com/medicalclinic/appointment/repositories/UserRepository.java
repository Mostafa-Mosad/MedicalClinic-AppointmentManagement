package com.medicalclinic.appointment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalclinic.appointment.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByFirstName(String firstName);

}
