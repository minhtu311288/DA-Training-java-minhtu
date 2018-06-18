package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "user",schema = "public")
public class User {
 
    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Long user_id;
 
    @Column(name = "username", length = 36, nullable = false)
    private String userName;
 
    @Column(name = "password", length = 128, nullable = false)
    private String password;
 
    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;
    public User() {
    	
    }
    public User(String userName2, String password2, List<GrantedAuthority> grantList) {
		this.userName = userName2;
		this.password = password2;
	}

	public Long getUserId() {
        return user_id;
    }
 
    public void setUserId(Long userId) {
        this.user_id = userId;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String encrytedPassword) {
        this.password = encrytedPassword;
    }
 
    public boolean isEnabled() {
        return enabled;
    }
 
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
 
}
