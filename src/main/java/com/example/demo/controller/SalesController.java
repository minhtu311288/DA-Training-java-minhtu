package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sales;
import com.example.demo.services.SalesService;

@RestController(value = SalesController.BASE_URL)
public class SalesController extends BaseController {
	
	public static final String BASE_URL = "/sales/";
	
	public static final String All_SALES = "/all";
	
	@Autowired
	SalesService salesservice;
	
	@RequestMapping(value = BASE_URL + All_SALES,method = RequestMethod.GET)
	public List<Sales> listSales(){
		
		return salesservice.findAll();
		
    }
}
