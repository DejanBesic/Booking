package com.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.app.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{

}
