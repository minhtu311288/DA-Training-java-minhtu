package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Times;
import com.example.demo.services.TimeService;


@RestController
public class timecontroller {
	@Autowired
	TimeService timeservice;
	
	@RequestMapping(value="/time/", method = RequestMethod.GET)
	public List<Times> listTimes(){
		return timeservice.findAll();
    }
}
