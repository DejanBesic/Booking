package com.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.app.service.impl.FacilityTypeServiceImpl;

@RestController
@RequestMapping("/api/types")
public class FacilityTypeController {

	@Autowired
	FacilityTypeServiceImpl facilityTypeService;


    @GetMapping
    public ResponseEntity<?> getTypes() {
    	return new ResponseEntity<>(facilityTypeService.findAll(), HttpStatus.OK);
    }
    
}
