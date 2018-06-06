package com.example.demo.model;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("product")
public class Productcassandra{
	@PrimaryKey
	@Column("product_id")
	private int product_id;
	@Column("item")
	private int item;
	@Column("inventory")
	private String inventory;
	@Column("create_at")
	private Date create_at;
	@Column("modified_at")
	private Date modified_at;
	@Column("class_field")
	private String class_field;
	public int getProduct_Id() {
        return product_id;
    }
    public void setiProduct_id(int product_id) {
        this.product_id = product_id;
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

	public String getClass_field() {
		return class_field;
	}

	public void setClass_field(String class_field) {
		this.class_field = class_field;
	}
}