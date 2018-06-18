package com.booking.app.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.DTOs.SearchRequest;
import com.booking.app.DTOs.SearchResponse;
import com.booking.app.model.Appointment;
import com.booking.app.model.Facility;
import com.booking.app.model.Image;
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
	public List<SearchResponse> findBySearch(SearchRequest searchRequest) {
		List<Facility> facilities = facilityService.filterFacility(searchRequest);
		List<Appointment> appointments =  appointmentRepository.findAll().stream()
				.filter(appointment -> {
					if (facilities.contains(appointment.getFacility())) {
						return true;
					}
					return false;
				})
				.filter(appointment -> {
					int startDate =searchRequest.getStartDate().compareTo(appointment.getFromDate()); 
					int endDate = searchRequest.getEndDate().compareTo(appointment.getToDate());
					if (startDate >= 0 && endDate <= 0){
						return true;
					} 
					return false;
				})
				.collect(Collectors.toList());
		
		return appointmentsToSearchResponses(appointments, searchRequest.getStartDate(), searchRequest.getEndDate());
	}
	
	private List<SearchResponse> appointmentsToSearchResponses(List<Appointment> appointments, Date startDate, Date endDate){
		List<SearchResponse> responses = new ArrayList<SearchResponse>();
		for (Appointment a : appointments) {
			responses.add(new SearchResponse(a, new ArrayList<Image>(), startDate, endDate));
		}
		return responses;
	}

}
