package com.example.demo.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Date create_at;
	
	@Column(name = "modified_at")
	private Date modified_at;
	
	public UUID getLocation_id() {
		return location_id;
	}
	
	public Locations() {
	}

	public Locations(UUID uuid, String string, String string2, Date date, Date date2) {
		this.location_id = uuid;
		this.country = string;
		this.city = string2;
		this.create_at = date;
		this.modified_at = date2;
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

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getModified_at() {
		return modified_at;
	}

	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}

}
