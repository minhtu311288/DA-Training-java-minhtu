package com.example.demo.dto;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import com.example.demo.utils.DateTimeUtil;

public class ProductDTO {
	
	private UUID product_id;
	
	private int item;
	
	private String class_field;
	
	private String inventory;
	
	private Date create_at;
	
	private Date modified_at;
	
	
	public UUID getProduct_id() {
		return product_id;
	}

	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getClass_field() {
		return class_field;
	}

	public void setClass_field(String class_field) {
		this.class_field = class_field;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getCreate_at() throws ParseException {
		
		String timeformat = DateTimeUtil.datetimeformat(create_at);
		
		return timeformat;
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
