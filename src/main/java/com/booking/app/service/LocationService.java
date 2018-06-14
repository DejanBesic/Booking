package com.booking.app.service;

import java.util.List;

import com.booking.app.model.Location;

public interface LocationService {

	Location findByid(Long id);
	
	Location findByName(String name);
	
	List<Location> findAll();
	
	
}
