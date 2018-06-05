package com.example.demo.respo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Products;

@Component
public interface productlist extends JpaRepository<Products, Long> {
}
