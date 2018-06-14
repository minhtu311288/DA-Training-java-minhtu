package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name="product")
public class Products {
	@Id
	@Column(name = "product_id")
	private UUID product_id;
	
	@Column(name = "item")
	private int item;
	
	@Column(name = "class_field")
	private String class_field;
	
	@Column(name = "inventory")
	private String inventory;
	
	@Column(name = "create_at")
	private DateTime create_at;
	
	@Column(name = "modified_at")
	private DateTime modified_at;
	
	public Products() {
	}
	public Products(UUID uuid, int item, String class_field, String inventory, DateTime date, DateTime date2) {
		this.product_id =uuid;
		this.item=item;
		this.class_field = class_field;
		this.inventory=inventory;
		this.modified_at=date2;
		this.create_at=date;
	}
	
	public UUID getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(UUID product_id) {
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
	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", item=" + item + ", class_field=" + class_field + ", inventory="
				+ inventory + ", create_at=" + create_at + ", modified_at=" + modified_at + "]";
	}
	
}
