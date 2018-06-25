package com.example.demo.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="time")
public class Times {
	@Id
	@Column(name = "time_id")
	private UUID time_id;
	
	@Column(name= "year")
	private int year;
	
	@Column(name ="month")
	private int month;
	
	@Column(name ="quater")
	private int quater;
	
	@Column(name = "create_at")
	private Date create_at;
	
	@Column(name = "modified_at")
	private Date modified_at;
	
	public Times() {
		
	}
	
	public Times(UUID uuid, int y, int m, int q, Date date, Date date2) {
		this.time_id = uuid;
		this.year = y;
		this.month = m;
		this.quater = q;
		this.create_at = date;
		this.modified_at = date2;
	}

	public UUID getTime_id() {
		return time_id;
	}

	public void setTime_id(UUID time_id) {
		this.time_id = time_id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getQuater() {
		return quater;
	}

	public void setQuater(int quater) {
		this.quater = quater;
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
