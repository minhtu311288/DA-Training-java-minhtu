package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Products;
import com.example.demo.services.ProductService;



@RestController
public class productcontroller {
	
	@Autowired
	ProductService productservice;
	@GetMapping("product")
	public ResponseEntity<List<Products>> getAllLocations(){
		List<Products> products = productservice.findAll();
		return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
	}
}
