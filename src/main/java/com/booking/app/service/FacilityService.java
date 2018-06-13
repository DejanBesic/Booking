package com.booking.app.service;

import java.util.List;

import com.booking.app.model.Facility;

public interface FacilityService {
	
	Facility findById(Long id);
	
	List<Facility> findAll();
	
	Facility save(Facility facility);
	
	void delete(Long id);

}
