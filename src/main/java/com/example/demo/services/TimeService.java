package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import com.example.demo.dto.TimeDTO;
import com.example.demo.model.Times;

public interface TimeService {
	List<Times> findAll();

	List<Times> getTimes();

	TimeDTO findById(UUID UUID);

	String save();

	TimeDTO getTimeByID(UUID UUID);
}
