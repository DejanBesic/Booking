package com.booking.app.service;

import com.booking.app.model.Image;

public interface ImageService {

	Image findById(Long id);
	
	Image save(Image image);
	
	void delete(Long id);
}
