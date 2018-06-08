package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Times;
import com.example.demo.respo.timelist;

@Service
public class TimeServiceImpl implements TimeService {
	@Autowired
	private timelist timeList;

	@Override
	public List<Times> findAll() {
		List<Times> Times = (List<Times>) timeList.findAll();
		return Times;
	}
	
}
