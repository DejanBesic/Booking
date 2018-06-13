package com.booking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.model.FacilityType;
import com.booking.app.repository.FacilityTypeRepository;
import com.booking.app.service.FacilityTypeService;

@Service
public class FacilityTypeServiceImpl implements FacilityTypeService {

	@Autowired
	FacilityTypeRepository facilityTypeRepository;
	
	@Override
	public FacilityType findById(Long id) {
		return facilityTypeRepository.findOne(id);
	}

	@Override
	public FacilityType save(FacilityType facilityType) {
		return facilityTypeRepository.save(facilityType);
	}

	@Override
	public FacilityType findByName(String name) {
		return facilityTypeRepository.findByName(name);
	}

	@Override
	public List<FacilityType> findAll() {
		return facilityTypeRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		facilityTypeRepository.delete(id);
		
	}
	
	

}
