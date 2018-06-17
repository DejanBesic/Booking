package com.booking.app.DTOs;

import java.sql.Date;

public class SearchRequest {

	private String location;
	
	private int people;
	
	private Date startDate;
	
	private Date endDate;
	
	private int type;
	
	private int category;
	
	private boolean parking;
	
	private boolean wifi;
	
	private boolean breakfast;
	
	private boolean halfBoard;
	
	private boolean fullBoard;
	
	private boolean tv;
	
	private boolean kitchen;
	
	private boolean bathroom;

	public SearchRequest(){
		
	}
	
	

	public SearchRequest(String location, int people, Date startDate, Date endDate, int type, int category,
			boolean parking, boolean wifi, boolean breakfast, boolean halfBoard, boolean fullBoard, boolean tv,
			boolean kitchen, boolean bathroom) {
		super();
		this.location = location;
		this.people = people;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.category = category;
		this.parking = parking;
		this.wifi = wifi;
		this.breakfast = breakfast;
		this.halfBoard = halfBoard;
		this.fullBoard = fullBoard;
		this.tv = tv;
		this.kitchen = kitchen;
		this.bathroom = bathroom;
	}



	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
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
	
	
	
}
