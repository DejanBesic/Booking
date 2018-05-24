package com.booking.app.web;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.app.model.Role;
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
	
	@PreAuthorize("hasAuthority('REGULAR')")
	@RequestMapping(value="/getUsersEmail", method = RequestMethod.GET)
	public ResponseEntity<String> getUsersEmail(){
		User user = getUser();
		return new ResponseEntity<>(user.getEmail(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('AGENT')")
	@RequestMapping(value="/getUsersCol", method = RequestMethod.GET)
	public ResponseEntity<String> getUsersCol(){
		return new ResponseEntity<>("yellow", HttpStatus.OK);
	}
	
	public User getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(auth.getName());
		return user;
	}
	
	@RequestMapping(value="/getUserRole", method = RequestMethod.GET)
	public ResponseEntity<?> getUs(){
		User user = getUser();
//		Iterator<Role> it = user.getRoles().iterator();
//		return new ResponseEntity<>(it.next().getName(), HttpStatus.OK);

		for (Iterator<Role> it = user.getRoles().iterator(); it.hasNext(); ) {
	        Role f = it.next();
	        return new ResponseEntity<>(f.getName(), HttpStatus.OK);
	    }
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
