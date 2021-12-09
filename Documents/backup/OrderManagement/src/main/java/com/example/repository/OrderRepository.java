package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Orders;


@Repository
public interface OrderRepository extends MongoRepository<Orders, Integer>{

}
