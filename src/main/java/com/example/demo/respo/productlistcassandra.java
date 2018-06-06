package com.example.demo.respo;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Productcassandra;
@Repository 
public interface productlistcassandra extends CassandraRepository<Productcassandra, Integer> {

}