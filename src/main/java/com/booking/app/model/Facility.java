package com.booking.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@ManyToOne(optional = true)
	private User owner;
	
	@ManyToOne(optional = true)
	private FacilityType type;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = false)
	private String address;
	
	@ManyToOne(optional = true)
	private Location location;
	
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
	private int numberOfPeople;
	
	public Facility() {
		
	}

	public Facility(String name, int category, User owner, FacilityType type, String description, String address,
			Location location, int numberOfPeople, boolean parkingLot, boolean wifi, boolean breakfast, boolean halfBoard,
			boolean fullBoard, boolean tv, boolean kitchen, boolean bathroom) {
		super();
		this.name = name;
		Category = category;
		this.owner = owner;
		this.type = type;
		this.description = description;
		this.address = address;
		this.location = location;
		this.parkingLot = parkingLot;
		this.wifi = wifi;
		this.breakfast = breakfast;
		this.halfBoard = halfBoard;
		this.fullBoard = fullBoard;
		this.tv = tv;
		this.kitchen = kitchen;
		this.bathroom = bathroom;
		this.numberOfPeople = numberOfPeople;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
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



	public Location getLocation() {
		return location;
	}




	public void setLocation(Location location) {
		this.location = location;
	}




	public boolean isParkingLot() {
		return parkingLot;
	}




	public void setParkingLot(boolean parkingLot) {
		this.parkingLot = parkingLot;
	}




	public boolean isWifi() {
		return wifi;
	}




	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}




	public boolean isBreakfast() {
		return breakfast;
	}




	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}




	public boolean isHalfBoard() {
		return halfBoard;
	}




	public void setHalfBoard(boolean halfBoard) {
		this.halfBoard = halfBoard;
	}




	public boolean isFullBoard() {
		return fullBoard;
	}




	public void setFullBoard(boolean fullBoard) {
		this.fullBoard = fullBoard;
	}




	public boolean isTv() {
		return tv;
	}




	public void setTv(boolean tv) {
		this.tv = tv;
	}




	public boolean isKitchen() {
		return kitchen;
	}




	public void setKitchen(boolean kitchen) {
		this.kitchen = kitchen;
	}




	public boolean isBathroom() {
		return bathroom;
	}




	public void setBathroom(boolean bathroom) {
		this.bathroom = bathroom;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}