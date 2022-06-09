package com.medicalclinic.appointment.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medicalclinic.appointment.DTO.AppointmentDTO;
import com.medicalclinic.appointment.models.Appointment;
import com.medicalclinic.appointment.models.Cancelation;
import com.medicalclinic.appointment.services.AppointmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/appointment")
@Slf4j
public class AppointmentController {

	private AppointmentService appointmentService;
	
	@Autowired
	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	
	@PostMapping("/addAppointment")
	public ResponseEntity<AppointmentDTO> addAppointment(@Valid @RequestBody Appointment appointment) {
		log.info("AppointmentController - addAppointment(): add new appointment");
		AppointmentDTO appointmentDTO = appointmentService.addAppointment(appointment);
		return new ResponseEntity<AppointmentDTO>(appointmentDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllAppointments")
	public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
		log.info("AppointmentController - addAppointment(): get all appointments");
		List<AppointmentDTO> appointments = appointmentService.getAllAppointments();
		return new ResponseEntity<List<AppointmentDTO>>(appointments, HttpStatus.OK);
	}
	
	@PostMapping("/cancelAppointment/{appointmentId}")
	public ResponseEntity<?> cancelAppointment(@PathVariable("appointmentId") Long appointmentId, @Valid @RequestBody Cancelation cancelation) {
		appointmentService.cancelAppointment(appointmentId, cancelation);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getAllAppointmentsByPatientName")
	public ResponseEntity<List<AppointmentDTO>> getAllAppointmentsByPatientName(@RequestParam("patientFirstName") String patientFirstName) {
		log.info("AppointmentController - addAppointment(): filter appointments by patient first name: {}", patientFirstName);
		List<AppointmentDTO> appointments = appointmentService.getAppointmentByPatientFirstName(patientFirstName);
		return new ResponseEntity<List<AppointmentDTO>>(appointments, HttpStatus.OK);
	}
	
	@GetMapping("/getAllAppointmentsByPatientId/{patientId}")
	public ResponseEntity<List<AppointmentDTO>> getAllAppointmentsByPatientName(@PathVariable("patientId") Long patientId) {
		log.info("AppointmentController - addAppointment(): filter appointments by patient Id: {}", patientId);
		List<AppointmentDTO> appointments = appointmentService.getAppointmentByPatientId(patientId);
		return new ResponseEntity<List<AppointmentDTO>>(appointments, HttpStatus.OK);
	}
	
	@GetMapping("/getAllAppointmentsByDate")
	public ResponseEntity<List<AppointmentDTO>> getAllAppointmentsByPatientDate(@RequestParam("date") Date date) {
		log.info("AppointmentController - addAppointment(): filter appointments by date: {}", date);
		List<AppointmentDTO> appointments = appointmentService.getAppointmentByDate(date);
		return new ResponseEntity<List<AppointmentDTO>>(appointments, HttpStatus.OK);
	}
}
