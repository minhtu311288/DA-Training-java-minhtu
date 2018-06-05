package com.example.demo.cassandramodel;

import java.sql.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value="product")
public class productcassandra {

	@PrimaryKey
	private int product_id;
	private int item;
	private String class_field;
	private String inventory;
	private Date create_at;
	private Date modified_at;
	public String getClass_field() {
		return class_field;
	}
	public void setClass_field(String class_field) {
		this.class_field = class_field;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
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
