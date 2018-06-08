package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sales;
import com.example.demo.services.SalesService;

@RestController
public class salescontroller {
	@Autowired
	SalesService salesservice;
	@RequestMapping(value="/sales/", method = RequestMethod.GET)
	public List<Sales> listSales(){
		return salesservice.findAll();
    }
}
