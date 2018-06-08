package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Locations;
import com.example.demo.services.LocationService;


@RestController
public class locationcontroller {
	@Autowired
	LocationService locationservice;
	
	@RequestMapping(value="/location/", method = RequestMethod.GET)
	public List<Locations> listLocations(){
		return locationservice.findAll();
    }
}
