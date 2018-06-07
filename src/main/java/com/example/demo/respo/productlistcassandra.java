package com.example.demo.respo;


import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.demo.model.Productcassandra;

public interface productlistcassandra extends CassandraRepository<Productcassandra, Integer> {

}