package com.medicalclinic.appointment.models;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Cancelation {
	
	private Boolean isCanceled = true;
	
	@NotBlank(message = "Reason is required")
	private String reason;

}
