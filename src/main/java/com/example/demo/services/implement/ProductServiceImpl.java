package com.example.demo.services.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Products;
import com.example.demo.respo.productlist;
import com.example.demo.services.ProductService;
import com.example.demo.utils.LogUtil;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProductServiceImpl implements ProductService {
	
	private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
	
	@Autowired
    private productlist listproduct;

    @Autowired
    public ProductServiceImpl(productlist productList1) {
    	
        this.listproduct = productList1;
        
    }

    @Override
	public List<Products> findAll(){
    	
		List<Products> products = (List<Products>) listproduct.findAll();
		
		return products;
	}
    
    @Override
    public ProductDTO findById(UUID UUID) {
    	
    	Products products = listproduct.findById(UUID).get();
    	
    	ModelMapper modelMapper = new ModelMapper();
    	
		ProductDTO productDto = modelMapper.map(products, ProductDTO.class);
		
		LogUtil.debug(this.getClass(),"show product inpocess");
    	
    	if (products == null) { 
    		return null;
    	}
    	
		return productDto;
    }
    @Override
	public String save(){
    	
		UUID uuid = UUID.randomUUID();
		
        Date date = new Date();
        
		Products pr = new Products(uuid,1, "class field","inven", date, date);
		
		listproduct.save(pr);
		
		return uuid.toString();
	}
}
