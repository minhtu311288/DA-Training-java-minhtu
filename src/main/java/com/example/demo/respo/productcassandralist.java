package com.example.demo.respo;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.cassandramodel.productcassandra;


public interface productcassandralist extends CrudRepository<productcassandra, Long> {
	@Query(value="SELECT * FROM product")
	public List<productcassandra> findAllProduct();
}	
