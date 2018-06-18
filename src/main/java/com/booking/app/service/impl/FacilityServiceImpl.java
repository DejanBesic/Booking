package com.booking.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.DTOs.SearchRequest;
import com.booking.app.model.Facility;
import com.booking.app.model.User;
import com.booking.app.repository.FacilityRepository;
import com.booking.app.service.FacilityService;

@Service
public class FacilityServiceImpl implements FacilityService{

	@Autowired
	FacilityRepository facilityRepository;
	
	@Override
	public Facility findById(Long id) {
		return facilityRepository.findOne(id);
	}

	@Override
	public List<Facility> findAll() {
		return facilityRepository.findAll();
	}

	@Override
	public Facility save(Facility facility) {
		return facilityRepository.save(facility);
	}

	@Override
	public void delete(Long id) {
		facilityRepository.delete(id);
		
	}

	@Override
	public List<Facility> filterFacility(SearchRequest searchRequest) {
		return facilityRepository.findAll()
    		.stream()
    			//filter location
				.filter(facility -> {
					if(facility.getLocation().getName().equals(searchRequest.getLocation())) {
						return true;
					} else {
						return false;
					}
				})    	
	    		//filter number of people
	    		.filter(facility -> {
					if(facility.getNumberOfPeople() == searchRequest.getPeople()) {
						return true;
					} else {
						return false;
					}
				})
	    		//filter type
	    		.filter(facility -> {
	    			if (searchRequest.getType() != -1) {
						if(facility.getType().getId() == searchRequest.getType()) {
							return true;
						} else {
							return false;
						}
	    			} else {
	    				return true;
	    			}
				})
	    		//filter category
	    		.filter(facility -> {
	    			if (searchRequest.getCategory() != -1) {
						if(facility.getCategory() == searchRequest.getCategory()) {
							return true;
						} else {
							return false;
						}
	    			} else {
	    				return true;
	    			}
				})
	    		//filter bathroom
	    		.filter(facility -> {
	    			if(searchRequest.isBathroom()) {
	    				if(facility.isBathroom()) {
	    					return true;
	    				} else {
	    					return false;
	    				}
	    			} else {
	    				return true;
	    			}
				})
	    		//filter breakfast
	    		.filter(facility -> {
	    			if(searchRequest.isBreakfast()) {
	    				if(facility.isBreakfast()) {
	    					return true;
	    				} else {
	    					return false;
	    				}
	    			} else {
	    				return true;
	    			}
	    		})
	    		//filter fullboard
	    		.filter(facility -> {
	    			if(searchRequest.isFullBoard()) {
	    				if(facility.isFullBoard()) {
	    					return true;
	    				} else {
	    					return false;
	    				}
	    			} else {
	    				return true;
	    			}
	    		})
	    		//filter halfboard
	    		.filter(facility -> {
	    			if(searchRequest.isHalfBoard()) {
	    				if(facility.isHalfBoard()) {
	    					return true;
	    				} else {
	    					return false;
	    				}
	    			} else {
	    				return true;
	    			}
	    		})
	    		//filter kitchen
	    		.filter(facility -> {
	    			if(searchRequest.isKitchen()) {
	    				if(facility.isKitchen()) {
	    					return true;
	    				} else {
	    					return false;
	    				}
	    			} else {
	    				return true;
	    			}
	    		})
	    		//filter parking
	    		.filter(facility -> {
	    			if(searchRequest.isParking()) {
	    				if(facility.isParkingLot()) {
	    					return true;
	    				} else {
	    					return false;
	    				}
	    			} else {
	    				return true;
	    			}
	    		})
	    		//filter tv
	    		.filter(facility -> {
	    			if(searchRequest.isTv()) {
	    				if(facility.isTv()) {
	    					return true;
	    				} else {
	    					return false;
	    				}
	    			} else {
	    				return true;
	    			}
	    		})
	    		//filter wifi
	    		.filter(facility -> {
	    			if(searchRequest.isWifi()) {
	    				if(facility.isWifi()) {
	    					return true;
	    				} else {
	    					return false;
	    				}
	    			} else {
	    				return true;
	    			}
	    		}).collect(Collectors.toList());

	}

	@Override
	public List<Facility> findByOwner(User user) {
		// TODO Auto-generated method stub
		return facilityRepository.findByOwner(user);
	}
	
}
