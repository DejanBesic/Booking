package com.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}