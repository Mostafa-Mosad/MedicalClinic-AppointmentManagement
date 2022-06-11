package com.medicalclinic.appointment.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medicalclinic.appointment.models.Appointment;
 
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
	List<Appointment> findAppointmentByPatientFirstName(String patientFirstName);
	
	@Query(value="select * from Appointment where appointment_date = :date", nativeQuery = true)
	List<Appointment> findByDate(@Param("date") Date date);
	
	List<Appointment> findAppointmentByPatientId(Long patientId);

}
