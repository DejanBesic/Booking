package com.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    User findByEmail(String email);
    
    User findByToken(String token);
}
