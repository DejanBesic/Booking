package com.booking.app.service;

import java.util.List;

import com.booking.app.model.Rating;

public interface RatingService {

	Rating findById(Long id);
	
	List<Rating> findAll();
	
	Rating save(Rating rating);
	
	void delete(Long id);
}
