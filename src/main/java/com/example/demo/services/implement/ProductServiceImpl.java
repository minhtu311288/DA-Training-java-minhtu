package com.example.demo.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Products;
import com.example.demo.respo.productlist;
import com.example.demo.services.ProductService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

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
    public Optional<Products> findById(UUID UUID) {
    	
    	Optional<Products> products = listproduct.findById(UUID);
    	
    	if (!products.isPresent()) return null;
    	
		return products;
    }
    @Override
	public String save(){
    	
		UUID uuid = UUID.randomUUID();
		
		Products pr = new Products(uuid,1, "class field","inven", new Date(), new Date());
		
		listproduct.save(pr);
		
		return uuid.toString();
	}
}
