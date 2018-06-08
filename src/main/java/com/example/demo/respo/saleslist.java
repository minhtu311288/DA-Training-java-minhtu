package com.example.demo.respo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SaleForeignKey;
import com.example.demo.model.Sales;


public interface saleslist extends JpaRepository<Sales, SaleForeignKey>  {

}
