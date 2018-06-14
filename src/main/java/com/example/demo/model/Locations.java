package com.example.demo.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name="location")
public class Locations {
	@Id
	@Column(name = "location_id")
	private UUID location_id;
	
	
	@Column(name= "country")
	private String country;
	
	@Column(name ="city")
	private String city;
	
	@Column(name = "create_at")
	private DateTime create_at;
	
	@Column(name = "modified_at")
	private DateTime modified_at;
	
	
	
	public UUID getLocation_id() {
		return location_id;
	}
	public Locations() {
	}
	public Locations(UUID location_id, String country, String city, DateTime create_at, DateTime modified_at) {
		this.location_id = location_id;
		this.country = country;
		this.city = city;
		this.create_at = create_at;
		this.modified_at = modified_at;
	}

	public void setLocation_id(UUID location_id) {
		this.location_id = location_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public DateTime getCreate_at() {
		return create_at;
	}

	public void setCreate_at(DateTime create_at) {
		this.create_at = create_at;
	}

	public DateTime getModified_at() {
		return modified_at;
	}

	public void setModified_at(DateTime modified_at) {
		this.modified_at = modified_at;
	}

	
}
