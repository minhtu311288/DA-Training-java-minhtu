package com.example.demo.services.implement;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.SaleDTO;
import com.example.demo.model.Sales;
import com.example.demo.respo.saleslist;
import com.example.demo.services.SalesService;
import com.example.demo.utils.LogUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class SalesServiceImpl implements SalesService {

	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	private saleslist salesList;
	
	@Override
	public List<Sales> findAll() {
		
		List<Sales> sales = (List<Sales>) salesList.findAll();
		
		return sales;
	}
	 @Override
	    public SaleDTO findById(UUID UUID) {
	    	
	    	Sales sales = salesList.findById(UUID).get();
	    	
	    	ModelMapper modelMapper = new ModelMapper();
	    	
	    	SaleDTO saleDto = modelMapper.map(sales, SaleDTO.class);
			
			LogUtil.debug(this.getClass(),"show sale inpocess");
	    	
	    	if (sales == null) { 
	    		return null;
	    	}
	    	
			return saleDto;
	    }
	    @Override
		public String save(){
	    	
			UUID uuid = UUID.randomUUID();
			
	        Date date = new Date();
	        
	        Sales s = new Sales(uuid,14d6aad8-e324-4b0f-a88c-e1d61a506e14, 14d6aad8-e324-4b0f-a88c-e1d61a506e14,14d6aad8-e324-4b0f-a88c-e1d61a506e14, 100, date, date);
			
			salesList.save(s);
			
			return uuid.toString();
		}
	    
	    @Override
	    public List<Sales> getSales() {
	    	
			QSales qsale = QSales.sales;
			
			JPAQueryFactory factory = new JPAQueryFactory(em);
			
			List<Sales> sales = factory.selectFrom(qsale).fetch();
			
			return sales;
			
		}
	    
	    @Override
	    public SaleDTO getSaleByID(UUID UUID) {
	    	
			QSales qSale = QSales.sales;
			
			JPAQueryFactory factory = new JPAQueryFactory(em);
			
			Sales sales = factory.selectFrom(qSale).where(qSale.sale_id.eq(UUID)).fetchOne();
			
			ModelMapper modelMapper = new ModelMapper();
	    	
			SaleDTO SaleDto = modelMapper.map(sales, SaleDTO.class);
			
			return SaleDto;
		}
}

