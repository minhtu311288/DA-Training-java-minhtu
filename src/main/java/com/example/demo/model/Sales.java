package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sales")
public class Sales {
	@EmbeddedId
	private SaleForeignKey saleForeignKey;
	
	@Column(name = "dollars")
	private int dollars;
	
	public Sales() {
		
	}
	public Sales(SaleForeignKey saleForeignKey, int dollars) {
		this.saleForeignKey = saleForeignKey;
		this.dollars = dollars;
	}

	public int getDollars() {
		return dollars;
	}

	public void setDollars(int dollars) {
		this.dollars = dollars;
	}
	
}
