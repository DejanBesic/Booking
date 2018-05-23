package com.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
