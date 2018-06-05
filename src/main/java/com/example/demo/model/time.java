package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="time")
public class time {
	private Integer time_id;
	private Integer year;
	private Integer month;
	private Integer quater;
	private Date create_at;
	private Date modified_at;
	@Id
	@GeneratedValue
	public Integer getTime_id() {
		return time_id;
	}
	public void setTime_id(Integer time_id) {
		this.time_id = time_id;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getQuater() {
		return quater;
	}
	public void setQuater(Integer quater) {
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
