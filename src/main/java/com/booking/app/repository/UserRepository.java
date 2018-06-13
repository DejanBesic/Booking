package com.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.app.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByEmail(String email);

    User findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);
    
    User findById(Long id);

    User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
