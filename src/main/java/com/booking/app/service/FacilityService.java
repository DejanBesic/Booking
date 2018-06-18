package com.booking.app.service;

import java.util.List;

import com.booking.app.DTOs.SearchRequest;
import com.booking.app.model.Facility;
import com.booking.app.model.User;

public interface FacilityService {
	
	Facility findById(Long id);
	
	List<Facility> findAll();
	
	Facility save(Facility facility);
	
	void delete(Long id);

	List<Facility> filterFacility(SearchRequest searchRequest);
	
	List<Facility> findByOwner(User user);
	
}
