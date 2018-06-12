package com.booking.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude()
	@Transient
	private MultipartFile images;

	@Column(nullable = true)
	@Lob
	private byte[] imagesDB;

	public Image() {
		
	}
	
	public Image(MultipartFile images, byte[] imagesDB) {
		super();
		this.images = images;
		this.imagesDB = imagesDB;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MultipartFile getImages() {
		return images;
	}

	public void setImages(MultipartFile images) {
		this.images = images;
	}

	public byte[] getImagesDB() {
		return imagesDB;
	}

	public void setImagesDB(byte[] imagesDB) {
		this.imagesDB = imagesDB;
	}
	
	

}
