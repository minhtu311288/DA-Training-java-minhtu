package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Products;

public interface ProductService {
	List<Products> findAll();
//	String save();
	Optional<Products> findById(UUID uUID);
}
