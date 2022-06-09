package com.medicalclinic.appointment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalclinic.appointment.models.Patient;
import com.medicalclinic.appointment.services.PatientService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/patient")
public class PatientController {

	private PatientService patientService;
	
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@PostMapping("/addPatient")
	public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) {
		log.info("PatientController - addPatient(): add new patient");
		Patient savedPatient = patientService.addPatient(patient);
		return new ResponseEntity<Patient>(savedPatient, HttpStatus.CREATED);
	}
	
	@GetMapping("/getPatientById/{patientId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("patientId") Long patientId) {
		log.info("PatientController - getPatientById(): get patient by Id={}", patientId);
		Patient patient = patientService.getPatientById(patientId);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePatientById/{patientId}")
	public void deletePatientById(@PathVariable("patientId") Long patientId) {
		log.info("PatientController - getPatientById(): delete patient by Id={}", patientId);
		patientService.deletePatientById(patientId);
		
	}
}
