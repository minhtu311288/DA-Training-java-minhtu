package com.example.demo.respo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Products;

@Repository
public interface productlist extends JpaRepository<Products, UUID> {
}
