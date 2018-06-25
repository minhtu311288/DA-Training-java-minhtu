package com.example.demo.services.implement;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LocationDTO;
import com.example.demo.model.Locations;
import com.example.demo.model.QLocations;
import com.example.demo.respo.locationlist;
import com.example.demo.services.LocationService;
import com.querydsl.jpa.impl.JPAQueryFactory;
@Service
public class LocationServiceImpl implements LocationService  {
	
	@Autowired
	private locationlist locationList;
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public List<Locations> findAll() {
		
		List<Locations> locations = (List<Locations>) locationList.findAll();
		
		return locations;
	}
	 @Override
	 public Optional<Locations> findById(UUID UUID) {
		 
	    Optional<Locations> locations = locationList.findById(UUID);
	    	
	    if (!locations.isPresent()) return null;
	    
		return locations;
	   }
	 
	 @Override
		public String save(){
	    	
			UUID uuid = UUID.randomUUID();
			
	        Date date = new Date();
	        
			Locations location = new Locations(uuid,"country 2", "city 2", date, date);
			
			locationList.save(location);
			
			return uuid.toString();
		}
	    
	    @Override
	    public List<Locations> getLocations() {
	    	
			QLocations qLocation = QLocations.locations;
			
			JPAQueryFactory factory = new JPAQueryFactory(em);
			
			List<Locations> locations = factory.selectFrom(qLocation).fetch();
			
			return locations;
			
		}
	    
	    @Override
	    public LocationDTO getLocationByID(UUID UUID) {
	    	
	    	QLocations qLocation = QLocations.locations;
			
			JPAQueryFactory factory = new JPAQueryFactory(em);
			
			Locations locations = factory.selectFrom(qLocation).where(qLocation.location_id.eq(UUID)).fetchOne();
			
			ModelMapper modelMapper = new ModelMapper();
	    	
			LocationDTO locationDto = modelMapper.map(locations, LocationDTO.class);
			
			return locationDto;
		}
}
