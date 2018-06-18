package com.booking.app.ws;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.booking.app.model.Facility;
import com.booking.app.model.User;
import com.booking.app.service.FacilityService;
import com.booking.app.service.FacilityTypeService;
import com.booking.app.service.LocationService;
import com.booking.app.service.UserService;
import com.xml.booking.backendmain.ws_classes.AgentFacilitiesWS;
import com.xml.booking.backendmain.ws_classes.FacilityWS;
import com.xml.booking.backendmain.ws_classes.TestRequest;
import com.xml.booking.backendmain.ws_classes.TestResponse;
import com.xml.booking.backendmain.ws_classes.UserWS;

@Endpoint
public class WSFacilityEndpoint {
	private static final String NAMESPACE_URI = "http://booking.xml.com/backendmain/ws-classes";
	
	@Autowired
	private FacilityService facilityService; 
	
	@Autowired
	private FacilityTypeService facilityTypeService; 
	
	@Autowired
	private LocationService locationService; 
	
	@Autowired
	private UserService userService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "testRequest")
	@ResponsePayload
	public TestResponse testRequest(@RequestPayload TestRequest request) {
		TestResponse response = new TestResponse();
		response.setName(request.getName().toUpperCase());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "userWS")
	@ResponsePayload
	public AgentFacilitiesWS getAgentFacilities(@RequestPayload UserWS user) {
		AgentFacilitiesWS response = new AgentFacilitiesWS();
		
		List<Facility> facilities = facilityService.findByOwner(userService.findById(user.getId()));
		for(Facility f : facilities){
			response.getFacilityWS().add(facility2WS(f));
		}
		
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "newFacility")
	@ResponsePayload
	public FacilityWS addNewFacility(@RequestPayload FacilityWS facilityWS){
		
		Facility saved = facilityService.save(ws2Facility(facilityWS));
		if(saved==null)
			return null;
		
		return facility2WS(saved);
	}
	
	private FacilityWS facility2WS(Facility facility){
		FacilityWS res = new FacilityWS();
		res.setId(facility.getId());
		res.setName(facility.getName());
		res.setCategory(facility.getCategory());
		res.setOwner(facility.getOwner().getUsername());
		res.setType(facility.getType().getName());
		res.setDescription(facility.getDescription());
		res.setAddress(facility.getAddress());
		res.setLocation(facility.getLocation().getName());
		res.setParkingLot(facility.isParkingLot());
		res.setBathroom(facility.isBathroom());
		res.setWifi(facility.isWifi());
		res.setBreakfast(facility.isBreakfast());
		res.setHalfBoard(facility.isHalfBoard());
		res.setFullBoard(facility.isFullBoard());
		res.setKitchen(facility.isKitchen());
		res.setTv(facility.isTv());
		res.setNumberOfPeople(facility.getNumberOfPeople());
		
		return res;
	}
	
	private Facility ws2Facility(FacilityWS facility){
		Facility res = new Facility();
		res.setName(facility.getName());
		res.setCategory(facility.getCategory());
		res.setOwner(userService.findByUsername(facility.getOwner()));
		res.setType(facilityTypeService.findByName(facility.getType()));
		res.setDescription(facility.getDescription());
		res.setAddress(facility.getAddress());
		res.setLocation(locationService.findByName(facility.getLocation()));
		res.setParkingLot(facility.isParkingLot());
		res.setBathroom(facility.isBathroom());
		res.setWifi(facility.isWifi());
		res.setBreakfast(facility.isBreakfast());
		res.setHalfBoard(facility.isHalfBoard());
		res.setFullBoard(facility.isFullBoard());
		res.setKitchen(facility.isKitchen());
		res.setTv(facility.isTv());
		res.setNumberOfPeople(facility.getNumberOfPeople());
		
		return res;
	}
	
	
}
