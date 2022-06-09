package com.medicalclinic.appointment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientExceptionController {

	@ExceptionHandler(value = PatientNotFoundException.class)
	public ResponseEntity<Object> exception(PatientNotFoundException ex) {
		return new ResponseEntity<Object>("Patient Not Found", HttpStatus.NOT_FOUND);
	}

}
