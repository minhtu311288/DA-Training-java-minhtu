package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TimeDTO;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Times;
import com.example.demo.services.TimeService;
import com.example.demo.utils.LogUtil;


@RestController(value = TimeController.BASE_URL)
public class TimeController extends BaseController {
	
	public static final String BASE_URL = "/time/";
	
	public static final String All_TIME = BASE_URL + "/all";
	
	public static final String GET_TIME_BY_ID_URL = BASE_URL + "/{id}";
	
	public static final String ADD_TIME = BASE_URL + "/addtime";
	
	
	
	@Autowired
	TimeService timeservice;
	
	@RequestMapping(value = All_TIME,method = RequestMethod.GET)
	public ResponseEntity<?> getAllTime(){
		
		LogUtil.debug(this.getClass(),"start list all times");
		
		List<Times> times = timeservice.getTimes();
		
		LogUtil.debug(this.getClass(),"end list all times");
		
		return new ResponseEntity<>(times, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = GET_TIME_BY_ID_URL,method = RequestMethod.GET)
	public ResponseEntity<?> getTimeByID(@PathVariable("id") UUID UUID) throws Exception {
		
		LogUtil.debug(this.getClass(),"start find product by id");
		
		TimeDTO time =  timeservice.getTimeByID(UUID);

		if (time == null) {
			throw new ProductNotFoundException("not found time!");
		}
		LogUtil.debug(this.getClass(),"End find time by id");
		
		return new ResponseEntity<>(time, HttpStatus.OK);
	}
	
	@RequestMapping(value = ADD_TIME,method = RequestMethod.GET)
	public ResponseEntity<String> addTime() throws Exception {
		
		LogUtil.debug(this.getClass(),"start add new time");
		
		timeservice.save();
		
		LogUtil.debug(this.getClass(),"add time successfully");
		
		return new ResponseEntity<String>("add time successfully", HttpStatus.OK);
	}
}
