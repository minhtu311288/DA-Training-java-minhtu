package com.example.demo.respo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.time;

@Component
public interface timelist extends JpaRepository<time, Long> {
	
}

