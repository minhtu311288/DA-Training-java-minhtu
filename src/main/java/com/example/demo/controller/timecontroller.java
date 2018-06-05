package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.time;
import com.example.demo.respo.timelist;

@RestController
@RequestMapping("/api")
public class timecontroller {
	
	@Autowired
	private timelist timeList;
	
	
	@RequestMapping(value="/time/", method = RequestMethod.GET)
	public List<time> findAll(){
		return timeList.findAll();
	}
}
