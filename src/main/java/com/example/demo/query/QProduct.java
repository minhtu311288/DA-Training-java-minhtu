package com.example.demo.query;

import com.example.demo.model.Products;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;

public abstract class QProduct extends EntityPathBase<Products> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final QProduct product = new QProduct("product");

}
