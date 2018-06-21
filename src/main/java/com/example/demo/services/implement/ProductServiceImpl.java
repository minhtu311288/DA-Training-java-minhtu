package com.example.demo.services.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Products;
import com.example.demo.query.QProduct;
import com.example.demo.respo.productlist;
import com.example.demo.services.ProductService;
import com.example.demo.utils.LogUtil;
import com.querydsl.jpa.impl.JPAQuery;

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
        
		Products pr = new Products(uuid,1, "class field","inven", date, date);
		
		listproduct.save(pr);
		
		return uuid.toString();
	}
    
    public ProductDTO getAllProduct() {
    	
    	QProduct qProduct = QProduct.product;
		
		JPAQuery query = (JPAQuery) new JPAQuery(em).from(qProduct);
		
		return query.list(qProduct);
    }
}
