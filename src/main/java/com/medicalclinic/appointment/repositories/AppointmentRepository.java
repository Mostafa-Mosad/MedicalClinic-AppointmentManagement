package com.medicalclinic.appointment.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medicalclinic.appointment.models.Appointment;
 
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
	List<Appointment> findAppointmentByPatientFirstName(String patientFirstName);
	
	@Query("select a from Appointment a where a.date <= :date")
	List<Appointment> findByDate(Date date);
	
	List<Appointment> findAppointmentByPatientId(Long patientId);

}
