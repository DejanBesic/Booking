package com.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.app.model.FacilityType;

@Repository
public interface FacilityTypeRepository extends JpaRepository<FacilityType, Long>{

	FacilityType findByName(String name);
}
