package com.medicalclinic.appointment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalclinic.appointment.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
