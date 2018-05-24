package com.booking.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.app.model.User;
import com.booking.app.repository.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class RestExampleController {

	@Autowired
	UserRepository userRepository;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/getUsers", method = RequestMethod.GET)
	public ResponseEntity<String> getUsers(){
		return new ResponseEntity<>("asaa", HttpStatus.OK);
	}
}
