package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.dto.LocationDTO;
import com.example.demo.model.Locations;

public interface LocationService {
	List<Locations> findAll();

	Optional<Locations> findById(UUID UUID);

	String save();

	List<Locations> getLocations();

	LocationDTO getLocationByID(UUID UUID);
}
