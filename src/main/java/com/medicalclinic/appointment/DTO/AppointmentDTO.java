package com.medicalclinic.appointment.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

	private Date date;
	
	private String time;
	
	private String patientFirstName;
	
	private String patientLastName;
	
	private int patientAge;
	
	private String patientPhone1;
	
	private String patientPhone2;
	
	private Boolean isCanceled;
	
	private String reason;
}
