package com.booking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.model.Appointment;
import com.booking.app.repository.AppointmentRepository;
import com.booking.app.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Override
	public Appointment findById(Long id) {
		return appointmentRepository.findOne(id);
	}

	@Override
	public List<Appointment> findAll() {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public void delete(Long id) {
		appointmentRepository.delete(id);
		
	}

}
