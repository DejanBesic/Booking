package com.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.app.DTOs.SearchRequest;
import com.booking.app.service.impl.AppointmentServiceImpl;
import com.booking.app.service.impl.FacilityServiceImpl;

@RestController
@RequestMapping("/api/facility")
public class FacilityController {

	@Autowired
	FacilityServiceImpl facilityService;

	@Autowired
	AppointmentServiceImpl appointmentService;
	

    @GetMapping
    public ResponseEntity<?> getFacilities() {
    	return new ResponseEntity<>(facilityService.findAll(), HttpStatus.OK);
    }
    
    @PostMapping(value="/search")
    public ResponseEntity<?> search(@RequestBody SearchRequest searchRequest){
    	if(searchRequest.getLocation().isEmpty() || searchRequest.getPeople() == 0 ||
    			searchRequest.getStartDate() == null || searchRequest.getStartDate().isEmpty() ||
				searchRequest.getEndDate() == null || searchRequest.getEndDate().isEmpty()) {
    		
    		return new ResponseEntity<>("Location, start date, end date and number of people are required.", HttpStatus.BAD_REQUEST);
    	}
    	
    	return new ResponseEntity<>(appointmentService.findBySearch(searchRequest), HttpStatus.OK);
    }
    
    
}

