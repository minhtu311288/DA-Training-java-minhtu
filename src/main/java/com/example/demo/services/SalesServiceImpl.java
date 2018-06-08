package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sales;
import com.example.demo.respo.saleslist;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private saleslist salesList;
	@Override
	public List<Sales> findAll() {
		List<Sales> sales = (List<Sales>) salesList.findAll();
		return sales;
	}
}
