package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import com.example.demo.dto.SaleDTO;
import com.example.demo.model.Sales;

public interface SalesService {
	List<Sales> findAll();

	SaleDTO getSaleByID(UUID uUID);

	String save();

	SaleDTO findById(UUID UUID);
}
