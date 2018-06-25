package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LocationDTO;
import com.example.demo.exception.LocationNotFoundException;
import com.example.demo.model.Locations;
import com.example.demo.services.LocationService;
import com.example.demo.utils.LogUtil;


@RestController(value = LocationController.BASE_URL)
public class LocationController extends BaseController {
	public static final String BASE_URL = "/location/";
	
	public static final String GET_LOCATION_BY_ID_URL = BASE_URL + "/{id}";
	
	public static final String ADD_LOCATION =  BASE_URL + "/addlocation";
	
	public static final String All_LOCATION =  BASE_URL + "/all";
	
	@Autowired
	LocationService locationservice;
	
	@RequestMapping(value = All_LOCATION,method = RequestMethod.GET)
	public List<Locations> listLocations(){
		
		return locationservice.getLocations();
    }
	
	@RequestMapping(value = GET_LOCATION_BY_ID_URL,method = RequestMethod.GET)
	public ResponseEntity<?> getLocationByID(@PathVariable("id") UUID UUID)throws Exception{
		
		LocationDTO location =  locationservice.getLocationByID(UUID);
		
		if (location == null) throw new LocationNotFoundException("not found location!");
		
		return new ResponseEntity<>(location, HttpStatus.OK);
	}
	
	@RequestMapping(value = ADD_LOCATION)
	public ResponseEntity<String> addLocation() throws Exception {
		
		LogUtil.debug(this.getClass(),"start add new location");
		
		locationservice.save();
		
		LogUtil.debug(this.getClass(),"add location successfully");
		
		return new ResponseEntity<String>("add location successfully", HttpStatus.OK);
	}
}
