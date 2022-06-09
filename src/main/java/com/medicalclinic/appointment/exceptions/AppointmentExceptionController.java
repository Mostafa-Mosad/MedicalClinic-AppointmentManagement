package com.medicalclinic.appointment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppointmentExceptionController {

	@ExceptionHandler(value = AppointmentNotFoundException.class)
	public ResponseEntity<Object> exception(AppointmentNotFoundException ex) {
		return new ResponseEntity<Object>("Appointment Not Found", HttpStatus.NOT_FOUND);
	}
}
