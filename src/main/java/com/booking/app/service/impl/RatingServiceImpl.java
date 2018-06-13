package com.booking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.model.Rating;
import com.booking.app.repository.RatingRepository;
import com.booking.app.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	RatingRepository ratingRepository;

	@Override
	public Rating findById(Long id) {
		return ratingRepository.findOne(id);
	}

	@Override
	public List<Rating> findAll() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating save(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public void delete(Long id) {
		ratingRepository.delete(id);
		
	}
	

}
