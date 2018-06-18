package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
     
    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Long role_id;
 

	@Column(name = "name", length = 30, nullable = false)
    private String name;
 
    public Role() {
    	
    }
    
    public Role(Long role_id, String name) {
		super();
		this.role_id = role_id;
		this.name = name;
	}
    
    public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
     
}
