package com.example.demo.controller;


import com.example.demo.respo.productcassandralist;
import com.example.demo.respo.productlist;
import com.example.demo.cassandramodel.productcassandra;
import com.example.demo.model.Products;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class productcontroller {
	
	@Autowired
	private productlist productList;
	@Autowired
	private productcassandralist productcassandraList;
	
	
	@RequestMapping(value="/productcassandra/", method = RequestMethod.GET)
	public List<productcassandra> findAllProduct1(){
		return productcassandraList.findAllProduct();
	}
	
	@RequestMapping(value="/product/", method = RequestMethod.GET)
	public List<Products> findAllProduct(){
		return productList.findAll();
	}
}
