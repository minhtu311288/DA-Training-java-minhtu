package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Locations;
import com.example.demo.respo.locationlist;
@Service
public class LocationServiceImpl implements LocationService  {
	@Autowired
	private locationlist locationList;

	@Override
	public List<Locations> findAll() {
		List<Locations> locations = (List<Locations>) locationList.findAll();
		return locations;
	}
}
