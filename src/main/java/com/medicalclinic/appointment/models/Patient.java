package com.medicalclinic.appointment.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PATIENT")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private Long id;
	
	@Column(name = "first_name")
	@NotBlank(message = "First name is required")
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank(message = "Last name is required")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "phone_1", unique = true)
	@NotBlank(message = "Phone is required")
	private String phone1;
	
	@Column(name = "phone_2", unique = true)
	private String phone2;
	
	@JsonIgnore
	@OneToMany(mappedBy = "patient", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private List<Appointment> appointment;
	
}
