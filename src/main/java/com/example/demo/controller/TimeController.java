package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Times;
import com.example.demo.services.TimeService;


@RestController(value = TimeController.BASE_URL)
public class TimeController extends BaseController {
	
	public static final String BASE_URL = "/time/";
	
	public static final String All_TIME = "/all";
	
	@Autowired
	TimeService timeservice;
	
	@RequestMapping(value = BASE_URL + All_TIME,method = RequestMethod.GET)
	public List<Times> listTimes(){
		
		return timeservice.findAll();
		
    }
}
