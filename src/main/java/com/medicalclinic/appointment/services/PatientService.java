package com.medicalclinic.appointment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalclinic.appointment.exceptions.PatientNotFoundException;
import com.medicalclinic.appointment.models.Patient;
import com.medicalclinic.appointment.repositories.PatientRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientService {
	
	private PatientRepository patientRepository;
	
	@Autowired
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	public Patient addPatient(Patient patient) {
		log.info("Add new patient: {}", patient.getFirstName() + " " + patient.getLastName());
		return patientRepository.save(patient);
	}
	
	public Patient getPatientById(Long patientId) {
		log.info("Get patient by Id={}", patientId);
		try {
		return patientRepository.findById(patientId).get();
		}
		catch (Exception e) {
			throw new PatientNotFoundException();
		}
	}
	
	public void deletePatientById(Long patientId) {
		log.info("Delete patient by id={}", patientId);
		try {
			patientRepository.deleteById(patientId);
		}
		catch (Exception e) {
			throw new PatientNotFoundException();
		}
	}
}
