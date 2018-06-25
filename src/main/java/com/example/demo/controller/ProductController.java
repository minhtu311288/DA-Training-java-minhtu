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

import com.example.demo.dto.ProductDTO;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Products;
import com.example.demo.services.ProductService;
import com.example.demo.utils.LogUtil;

@RestController(value = ProductController.BASE_URL)
public class ProductController extends BaseController {

	public static final String BASE_URL = "/product/";
	
	public static final String GET_PRODUCT_BY_ID_URL = BASE_URL + "/{id}";
	
	public static final String ADD_PRODUCT = BASE_URL + "/addproduct";
	
	public static final String All_PRODUCT = BASE_URL + "/all";
	
	@Autowired
	ProductService productservice;
	
	@RequestMapping(value = All_PRODUCT,method = RequestMethod.GET)
	public ResponseEntity<?> getAllProduct(){
		
		LogUtil.debug(this.getClass(),"start list all products");
		
		List<Products> products = productservice.getProducts();
		
		LogUtil.debug(this.getClass(),"end list all products");
		
		return new ResponseEntity<>(products, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = GET_PRODUCT_BY_ID_URL)
	public ResponseEntity<?> getProductByID(@PathVariable("id") UUID UUID) throws Exception {
		
		LogUtil.debug(this.getClass(),"start find product by id");
		
		ProductDTO product =  productservice.getProductByID(UUID);

		if (product == null) {
			throw new ProductNotFoundException("not found product!");
		}
		LogUtil.debug(this.getClass(),"End find product by id");
		
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = ADD_PRODUCT)
	public ResponseEntity<String> addProduct() throws Exception {
		
		LogUtil.debug(this.getClass(),"start add new product");
		
		productservice.save();
		
		LogUtil.debug(this.getClass(),"add product successfully");
		
		return new ResponseEntity<String>("add product successfully", HttpStatus.OK);
	}
}