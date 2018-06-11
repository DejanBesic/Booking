package com.booking.app.DTOs;

public class RegistrationResponse {

	private boolean registratedSuccesfully;
	
	private String value;

	public RegistrationResponse(boolean registratedSuccesfully, String value) {
		super();
		this.registratedSuccesfully = registratedSuccesfully;
		this.value = value;
	}

	public boolean isRegistratedSuccesfully() {
		return registratedSuccesfully;
	}

	public void setRegistratedSuccesfully(boolean registratedSuccesfully) {
		this.registratedSuccesfully = registratedSuccesfully;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
