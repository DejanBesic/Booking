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
	
	@PreAuthorize("hasRole('REGULAR')")
	@RequestMapping(value="/getUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}
}
