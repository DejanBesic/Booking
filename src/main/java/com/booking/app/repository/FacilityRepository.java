package com.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.app.model.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long>{

}
