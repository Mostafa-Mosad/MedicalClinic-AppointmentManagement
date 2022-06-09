package com.medicalclinic.appointment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.aspectj.weaver.tools.Trace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "first_name")
	@NotBlank(message = "First name is required")
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank(message = "Last name is required")
	private String lastName;
	
	@Column(name = "email", unique = true)
	@NotBlank(message = "Email is required")
	private String email;
	
	@Column(name = "phone_1", unique = true)
	@NotBlank(message = "Phone is required")
	private String phone1;
	
	@Column(name = "phone_2", unique = true)
	private String phone2;
	
	@Column(name = "role")
	@NotBlank(message = "Role is requied")
	private String role;
	

}
