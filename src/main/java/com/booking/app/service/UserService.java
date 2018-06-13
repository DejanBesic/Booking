package com.booking.app.service;

import java.util.List;

import com.booking.app.model.User;

public interface UserService {
	
	User save(User user);
	
	User findById(Long id);
	
	List<User> findAll();
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	void delete(Long id);

}
