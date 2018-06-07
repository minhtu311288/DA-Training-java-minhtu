package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.ProductService;
import com.example.demo.model.Products;

@RestController
@RequestMapping("/api")
public class productcontroller {
	
	@Autowired
	ProductService ProductService;
	
	@RequestMapping(value="/product/", method = RequestMethod.GET)
	public List<Products> listProducts(){
		return ProductService.findAll();
    }
//	@RequestMapping("/saveproduct/")
//	public String saveproduct(){
//		return ProductService.save();
//	}
}
