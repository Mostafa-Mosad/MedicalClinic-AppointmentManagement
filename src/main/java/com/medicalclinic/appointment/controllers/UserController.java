package com.medicalclinic.appointment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalclinic.appointment.models.User;
import com.medicalclinic.appointment.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		log.info("UserController - addUser(): add new user");
		User savedUser = userService.addUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable(name = "userId") Long userId) {
		log.info("UserController - getUserById(): Get user by Id={}", userId);
		User user = userService.getUserById(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getUserByName/{userName}")
	public ResponseEntity<List<User>> getUserByName(@PathVariable(name = "userName") String userName) {
		log.info("UserController - getUserById(): Get user by name={}", userName);
		List<User> users = userService.getUserByName(userName);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
