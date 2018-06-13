package com.booking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.model.Reservation;
import com.booking.app.repository.ReservationRepository;
import com.booking.app.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation findOne(Long id) {
		return reservationRepository.findOne(id);
	}

	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation save(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public void delete(Long id) {
		reservationRepository.delete(id);
	}
	
}
