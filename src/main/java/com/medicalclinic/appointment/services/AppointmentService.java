package com.medicalclinic.appointment.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalclinic.appointment.DTO.AppointmentDTO;
import com.medicalclinic.appointment.exceptions.AppointmentNotFoundException;
import com.medicalclinic.appointment.models.Appointment;
import com.medicalclinic.appointment.models.Cancelation;
import com.medicalclinic.appointment.models.Patient;
import com.medicalclinic.appointment.repositories.AppointmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppointmentService {
	
	private AppointmentRepository appointmentRepository;
	private PatientService patientService;
	
	@Autowired
	public AppointmentService(AppointmentRepository appointmentRepository, PatientService patientService) {
		this.appointmentRepository = appointmentRepository;
		this.patientService = patientService;
	}
	
	public AppointmentDTO addAppointment(Appointment appointment) {
		log.info("Add new appointment");
		Long patientId = appointment.getPatient().getPatientId();
		Patient patient = patientService.getPatientById(patientId);
		Appointment savedAppointment = appointmentRepository.save(appointment);
		AppointmentDTO appointmentDTO = AppointmentDTO.builder().date(savedAppointment.getDate())
				.time(savedAppointment.getTime())
				.patientFirstName(patient.getFirstName())
				.patientLastName(patient.getLastName())
				.patientAge(patient.getAge())
				.patientPhone1(patient.getPhone1())
				.patientPhone2(patient.getPhone2())
				.build();
		return appointmentDTO;
	}
	
	public List<AppointmentDTO> getAllAppointments() {
		log.info("Get all appointments");
		 List<Appointment> appointments = appointmentRepository.findAll();
		 List<AppointmentDTO> appointmentDTOs = new ArrayList<AppointmentDTO>();
		 for(Appointment appointment: appointments) {
			 AppointmentDTO appointmentDTO = AppointmentDTO.builder().date(appointment.getDate())
					    .time(appointment.getTime())
						.patientFirstName(appointment.getPatient().getFirstName())
						.patientLastName(appointment.getPatient().getLastName())
						.patientAge(appointment.getPatient().getAge())
						.patientPhone1(appointment.getPatient().getPhone1())
						.patientPhone2(appointment.getPatient().getPhone2())
						.isCanceled(appointment.getIsCanceled())
						.reason(appointment.getReason())
						.build();
			 appointmentDTOs.add(appointmentDTO);
		 }
		 
		 return appointmentDTOs;
	}
	
	public List<AppointmentDTO> getAppointmentByPatientFirstName(String patientFirstName) {
		log.info("Get All appointments for patient={}", patientFirstName);
		List<Appointment> appointments = appointmentRepository.findAppointmentByPatientFirstName(patientFirstName);
		List<AppointmentDTO> appointmentDTOs = new ArrayList<AppointmentDTO>();
		 for(Appointment appointment: appointments) {
			 AppointmentDTO appointmentDTO = AppointmentDTO.builder().date(appointment.getDate())
					    .time(appointment.getTime())
						.patientFirstName(appointment.getPatient().getFirstName())
						.patientLastName(appointment.getPatient().getLastName())
						.patientAge(appointment.getPatient().getAge())
						.patientPhone1(appointment.getPatient().getPhone1())
						.patientPhone2(appointment.getPatient().getPhone2())
						.isCanceled(appointment.getIsCanceled())
						.reason(appointment.getReason())
						.build();
			 appointmentDTOs.add(appointmentDTO);
		 }
		 
		 return appointmentDTOs;
	}
	
	public List<AppointmentDTO> getAppointmentByDate(Date date) {
		log.info("Get all appointments for date={}", date.toString());
		List<Appointment> appointments = appointmentRepository.findByDate(date);
		List<AppointmentDTO> appointmentDTOs = new ArrayList<AppointmentDTO>();
		 for(Appointment appointment: appointments) {
			 AppointmentDTO appointmentDTO = AppointmentDTO.builder().date(appointment.getDate())
					    .time(appointment.getTime())
						.patientFirstName(appointment.getPatient().getFirstName())
						.patientLastName(appointment.getPatient().getLastName())
						.patientAge(appointment.getPatient().getAge())
						.patientPhone1(appointment.getPatient().getPhone1())
						.patientPhone2(appointment.getPatient().getPhone2())
						.isCanceled(appointment.getIsCanceled())
						.reason(appointment.getReason())
						.build();
			 appointmentDTOs.add(appointmentDTO);
		 }
		 
		 return appointmentDTOs;
	}

	public void cancelAppointment(Long appointmentId, Cancelation cancelation) {
		log.info("Cancel appointment={}, and the reason is: {}", appointmentId, cancelation.getReason());
		try {
		Appointment appointment = appointmentRepository.findById(appointmentId).get();
		appointment.setIsCanceled(cancelation.getIsCanceled());
		appointment.setReason(cancelation.getReason());
		appointmentRepository.save(appointment);
		}
		catch (Exception e) {
			throw new AppointmentNotFoundException();
		}
		
	}
}
