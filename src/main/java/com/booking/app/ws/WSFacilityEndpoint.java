package com.booking.app.ws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.booking.app.model.Facility;
import com.booking.app.service.FacilityService;
import com.xml.booking.backendmain.ws_classes.FacilityRequest;
import com.xml.booking.backendmain.ws_classes.FacilityResponse;
import com.xml.booking.backendmain.ws_classes.TestRequest;
import com.xml.booking.backendmain.ws_classes.TestResponse;

@Endpoint
public class WSFacilityEndpoint {
	private static final String NAMESPACE_URI = "http://booking.xml.com/backendmain/ws-classes";
	
	@Autowired
	private FacilityService facilityService; 
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "testRequest")
	@ResponsePayload
	public TestResponse testRequest(@RequestPayload TestRequest request) {
		TestResponse response = new TestResponse();
		response.setName(request.getName().toUpperCase());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "facilityRequest")
	@ResponsePayload
	public FacilityResponse facilityRequest(@RequestPayload FacilityRequest request) {
		FacilityResponse response = new FacilityResponse();
		Facility facility = new Facility();
		
		facility.setName(request.getName().toUpperCase());
		facility.setAddress(request.getAddress());
		facility.setDescription(request.getDescription());
		facility.setCategory(request.getCategory());
		facility.setWifi(request.isWifi());
		facility.setBathroom(true);
		facility.setBreakfast(true);
		facility.setFullBoard(false);
		facility.setHalfBoard(true);
		facility.setKitchen(false);
		facility.setNumberOfPeople(2);
		facility.setParkingLot(false);
		facility.setTv(true);
				

		Facility saved = facilityService.save(facility);
		if(saved!=null){
			response.setName(saved.getName());
			response.setAddress(saved.getAddress());
			response.setDescription(saved.getDescription());
			response.setCategory(saved.getCategory());
		}else{
			return null;
		}
		//response.setName(request.getName().toUpperCase());
		return response;
	}
	
}
