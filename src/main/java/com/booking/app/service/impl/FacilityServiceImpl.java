package com.booking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.model.Facility;
import com.booking.app.repository.FacilityRepository;
import com.booking.app.service.FacilityService;

@Service
public class FacilityServiceImpl implements FacilityService{

	@Autowired
	FacilityRepository facilityRepository;
	
	@Override
	public Facility findById(Long id) {
		return facilityRepository.findOne(id);
	}

	@Override
	public List<Facility> findAll() {
		return facilityRepository.findAll();
	}

	@Override
	public Facility save(Facility facility) {
		return facilityRepository.save(facility);
	}

	@Override
	public void delete(Long id) {
		facilityRepository.delete(id);
		
	}

}
