package com.booking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.model.Location;
import com.booking.app.repository.LocationRepository;
import com.booking.app.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	LocationRepository locationRepository;
	
	@Override
	public Location findByid(Long id) {
		return locationRepository.findOne(id);
	}

	@Override
	public Location findByName(String name) {
		return locationRepository.findByName(name);
	}

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

}
