package com.booking.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.DTOs.SearchRequest;
import com.booking.app.model.Appointment;
import com.booking.app.model.Facility;
import com.booking.app.repository.AppointmentRepository;
import com.booking.app.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	FacilityServiceImpl facilityService;
	
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


	@Override
	public List<Appointment> findBySearch(SearchRequest searchRequest) {
		List<Facility> facilities = facilityService.filterFacility(searchRequest);
		
		return appointmentRepository.findAll().stream()
				.filter(appointment -> {
					if (facilities.contains(appointment.getFacility())) {
						return true;
					}
					return false;
				})
				.collect(Collectors.toList());
	}

}
