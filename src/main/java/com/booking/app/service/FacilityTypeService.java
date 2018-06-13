package com.booking.app.service;

import java.util.List;

import com.booking.app.model.FacilityType;

public interface FacilityTypeService {
	
	FacilityType findById(Long id);
	
	FacilityType save(FacilityType facilityType);
	
	FacilityType findByName(String name);
	
	List<FacilityType> findAll();
	
	void delete(Long id);

}
