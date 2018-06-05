package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Products {
	@Id
	@GeneratedValue
	private Integer product_id;
	private Integer item;
	private String class_field;
	private String inventory;
	private Date create_at;
	private Date modified_at;
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getItem() {
		return item;
	}
	public void setItem(Integer item) {
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
