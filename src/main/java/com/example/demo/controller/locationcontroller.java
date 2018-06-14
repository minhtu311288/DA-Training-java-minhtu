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


@RestController
public class locationcontroller {
	@Autowired
	LocationService locationservice;
	
	@RequestMapping(value="/locations/", method = RequestMethod.GET)
	public List<Locations> listLocations(){
		return locationservice.findAll();
    }
	@RequestMapping(value = "/location/{id}")
	public ResponseEntity<Optional<Locations>> getLocationByID(@PathVariable("id") UUID UUID)throws Exception{
		Optional<Locations> location =  locationservice.findById(UUID);
		if (location == null) throw new LocationNotFoundException("not found location!");
		return new ResponseEntity<Optional<Locations>>(location, HttpStatus.OK);
	}
}
