package com.example.demo.services.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Products;
import com.example.demo.model.QProducts;
import com.example.demo.respo.productlist;
import com.example.demo.services.ProductService;
import com.example.demo.utils.LogUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private productlist listproduct;
	
	@PersistenceContext
    private EntityManager em;

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
        
		Products pr = new Products(uuid,1, "class 1","inven 1", date, date);
		
		listproduct.save(pr);
		
		return uuid.toString();
	}
    
    @Override
    public List<Products> getProducts() {
    	
		QProducts qProduct = QProducts.products;
		
		JPAQueryFactory factory = new JPAQueryFactory(em);
		
		List<Products> products = factory.selectFrom(qProduct).fetch();
		
		return products;
		
	}
    
    @Override
    public ProductDTO getProductByID(UUID UUID) {
    	
		QProducts qProduct = QProducts.products;
		
		JPAQueryFactory factory = new JPAQueryFactory(em);
		
		Products products = factory.selectFrom(qProduct).where(qProduct.product_id.eq(UUID)).fetchOne();
		
		ModelMapper modelMapper = new ModelMapper();
    	
		ProductDTO productDto = modelMapper.map(products, ProductDTO.class);
		
		return productDto;
	}
}
