package com.medicalclinic.appointment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalclinic.appointment.exceptions.UserNotFoundException;
import com.medicalclinic.appointment.models.User;
import com.medicalclinic.appointment.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User addUser(User user) {
		log.info("Adding new user {}", user.getFirstName() + " " + user.getLastName());
		return userRepository.save(user);
	}

	public User getUserById(Long userId) {
		log.info("Get user by id= {}", userId);
		try {
		return userRepository.findById(userId).get();
		}
		catch (Exception e) {
			throw new UserNotFoundException();
		}
	}
	
	public List<User> getUserByName(String firstName) {
		log.info("Get User(s) by first name= {}", firstName);
		return userRepository.findByFirstName(firstName);
	}
}
