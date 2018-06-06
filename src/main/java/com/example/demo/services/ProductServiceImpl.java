package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Products;
import com.example.demo.respo.productlist;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private productlist productList;

    @Autowired
    public ProductServiceImpl(productlist productList) {
        this.productList = productList;
    }

    @Override
    public List<Products> listAll() {
        List<Products> products = new ArrayList<>();
        productList.findAll().forEach(products::add);
        return products;
    }
}
