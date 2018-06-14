package com.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.app.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

	Location findByName(String name);
}
