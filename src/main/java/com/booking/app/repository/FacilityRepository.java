package com.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.app.model.Facility;
import com.booking.app.model.User;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long>{

	List<Facility> findByOwner(User user);
}
