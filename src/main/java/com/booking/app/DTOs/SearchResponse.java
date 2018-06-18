package com.booking.app.DTOs;

import java.sql.Date;
import java.util.List;

import com.booking.app.model.Appointment;
import com.booking.app.model.Image;

public class SearchResponse {

	Appointment appointment;
	
	List<Image> images;
	
	Date startDate;
	
	Date endDate;

	public SearchResponse(Appointment appointment, List<Image> images, Date startDate, Date endDate) {
		super();
		this.appointment = appointment;
		this.images = images;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	
}
