package com.booking.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.model.Image;
import com.booking.app.repository.ImageRepository;
import com.booking.app.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	ImageRepository imageRepository;
	
	@Override
	public Image findById(Long id) {
		return imageRepository.findOne(id);
	}

	@Override
	public Image save(Image image) {
		return imageRepository.save(image);
	}

	@Override
	public void delete(Long id) {
		imageRepository.delete(id);
	}

}
