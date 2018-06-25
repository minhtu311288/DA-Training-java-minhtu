package com.example.demo.services;

import java.util.List;
import java.util.UUID;
import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Products;

public interface ProductService {
	
	List<Products> findAll();
	
	ProductDTO findById(UUID uUID);
	
	String save();
	
	List<Products> getProducts();
	
	ProductDTO getProductByID(UUID UUID);
	
}
