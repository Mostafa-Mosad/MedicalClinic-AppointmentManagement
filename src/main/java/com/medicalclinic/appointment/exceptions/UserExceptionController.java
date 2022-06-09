package com.medicalclinic.appointment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException ex) {
		return new ResponseEntity<Object>("User Not Found", HttpStatus.NOT_FOUND);
	}

}
