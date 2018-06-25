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

import com.example.demo.dto.SaleDTO;
import com.example.demo.exception.LocationNotFoundException;
import com.example.demo.model.Sales;
import com.example.demo.services.SalesService;
import com.example.demo.utils.LogUtil;

@RestController(value = SalesController.BASE_URL)
public class SalesController extends BaseController {
	
	public static final String BASE_URL = "/sales/";
	
	public static final String All_SALES = "/all";
	
	public static final String GET_SALE_BY_ID_URL = BASE_URL + "/{id}";
	
	public static final String ADD_SALE =  BASE_URL + "/addsale";
	
	@Autowired
	SalesService salesservice;
	
	@RequestMapping(value = All_SALES,method = RequestMethod.GET)
	public List<Sales> listSales(){
		
		return salesservice.findAll();
		
    }
	
	@RequestMapping(value = GET_SALE_BY_ID_URL,method = RequestMethod.GET)
	public ResponseEntity<?> getSaleByID(@PathVariable("id") UUID UUID)throws Exception{
		
		SaleDTO saleDto =  salesservice.getSaleByID(UUID);
		
		if (saleDto == null) throw new LocationNotFoundException("not found sale!");
		
		return new ResponseEntity<>(saleDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = ADD_SALE)
	public ResponseEntity<String> addSale() throws Exception {
		
		LogUtil.debug(this.getClass(),"start add new sale");
		
		salesservice.save();
		
		LogUtil.debug(this.getClass(),"add sale successfully");
		
		return new ResponseEntity<String>("add sale successfully", HttpStatus.OK);
	}
}
