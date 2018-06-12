package com.booking.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Facility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int Category;
	
	@ManyToOne(optional = false)
	private User owner;
	
	@ManyToMany
	private Set<Image> images;
	
	@ManyToOne(optional = false)
	private FacilityType type;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private boolean parkingLot;
	
	@Column(nullable = false)
	private boolean wifi;
	
	@Column(nullable = false)
	private boolean breakfast;
	
	@Column(nullable = false)
	private boolean halfBoard;
	
	@Column(nullable = false)
	private boolean fullBoard;
	
	@Column(nullable = false)
	private boolean tv;
	
	@Column(nullable = false)
	private boolean kitchen;
	
	@Column(nullable = false)
	private boolean bathroom;	
	
	@Column(nullable = false)
	private int numberOfPepople;
	
	public Facility() {
		
	}

	public Facility(String name, int category, User owner, Set<Image> images,
			FacilityType type, String description, String address, int numberOfPepople) {
		super();
		this.name = name;
		Category = category;
		this.owner = owner;
		this.images = images;
		this.type = type;
		this.description = description;
		this.address = address;
		this.numberOfPepople = numberOfPepople;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCategory() {
		return Category;
	}


	public void setCategory(int category) {
		Category = category;
	}


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}


	public Set<Image> getImages() {
		return images;
	}


	public void setImages(Set<Image> images) {
		this.images = images;
	}


	public FacilityType getType() {
		return type;
	}


	public void setType(FacilityType type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getNumberOfPepople() {
		return numberOfPepople;
	}


	public void setNumberOfPepople(int numberOfPepople) {
		this.numberOfPepople = numberOfPepople;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}
