package com.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.app.service.impl.FacilityServiceImpl;

@RestController
@RequestMapping("/api/facility")
public class FacilityController {

	@Autowired
	FacilityServiceImpl facilityService;


    @GetMapping
    public ResponseEntity<?> getFacilities() {
    	return new ResponseEntity<>(facilityService.findAll(), HttpStatus.OK);
    }
    
    
}

