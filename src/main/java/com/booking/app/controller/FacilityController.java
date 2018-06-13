package com.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.app.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/facility")
public class FacilityController {

//	@Autowired
//	FacilityServiceImpl facilityService;
	
	@Autowired
	UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<?> getFacilities() {
    	//List<Facility> lista = facilityService.findAll();
    	return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    
    
}
