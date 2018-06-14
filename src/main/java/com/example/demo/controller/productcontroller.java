package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Products;
import com.example.demo.services.ProductService;


@Controller
@RestController
public class productcontroller {
	protected Logger logger;

	public productcontroller() {
		logger = LoggerFactory.getLogger(getClass());
	}
	@Autowired
	ProductService productservice;
	
	@RequestMapping("/products")
	public ResponseEntity<List<Products>> getAllLocations(){
		List<Products> products = productservice.findAll();
		return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product/{id}")
	public ResponseEntity<Optional<Products>> getProductByID(@PathVariable("id") UUID UUID)throws Exception{
		logger.debug("start find product by id");
		Optional<Products> product =  productservice.findById(UUID);
		if (product == null) throw new ProductNotFoundException("not found product!");
		logger.debug("End find product by id");
		return new ResponseEntity<Optional<Products>>(product, HttpStatus.OK);
	}
}