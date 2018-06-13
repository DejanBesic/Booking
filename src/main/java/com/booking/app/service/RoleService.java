	package com.booking.app.service;

import java.util.List;

import com.booking.app.model.Role;

public interface RoleService {

	Role findById(Long id);
	
	List<Role> findAll();
	
	Role findByName(String name);
	
	Role save(Role role);
	
	void delete(Long id);
	
}
