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

import com.example.demo.exception.LocationNotFoundException;
import com.example.demo.model.Locations;
import com.example.demo.services.LocationService;


@RestController(value = LocationController.BASE_URL)
public class LocationController extends BaseController {
	public static final String BASE_URL = "/location/";
	
	public static final String GET_LOCATION_BY_ID_URL = "/{id}";
	
	public static final String ADD_LOCATION = "/addlocation";
	
	public static final String All_LOCATION = "/all";
	@Autowired
	LocationService locationservice;
	
	@RequestMapping(value = BASE_URL + All_LOCATION,method = RequestMethod.GET)
	public List<Locations> listLocations(){
		
		return locationservice.findAll();
		
    }
	
	@RequestMapping(value = BASE_URL + GET_LOCATION_BY_ID_URL,method = RequestMethod.GET)
	public ResponseEntity<Optional<Locations>> getLocationByID(@PathVariable("id") UUID UUID)throws Exception{
		
		Optional<Locations> location =  locationservice.findById(UUID);
		
		if (location == null) throw new LocationNotFoundException("not found location!");
		
		return new ResponseEntity<Optional<Locations>>(location, HttpStatus.OK);
	}
}
