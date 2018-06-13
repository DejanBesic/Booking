package com.booking.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Image implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude()
	@Transient
	private MultipartFile images;

	@Column(nullable = true)
	@Lob
	private byte[] imagesDB;
	
	@ManyToOne(optional = false)
	private Facility facility;

	public Image() {
		
	}
	
	public Image(MultipartFile images, byte[] imagesDB, Facility facility) {
		super();
		this.images = images;
		this.imagesDB = imagesDB;
		this.facility = facility;
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

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	

}
