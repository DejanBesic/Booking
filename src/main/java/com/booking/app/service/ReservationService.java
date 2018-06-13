package com.booking.app.service;

import java.util.List;

import com.booking.app.model.Reservation;

public interface ReservationService {

	Reservation findOne(Long id);
	
	List<Reservation> findAll();
	
	Reservation save(Reservation reservation);
	
	void delete(Long id);
	
}
