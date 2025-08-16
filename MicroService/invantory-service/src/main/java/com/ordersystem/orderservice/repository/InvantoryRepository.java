package com.ordersystem.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ordersystem.orderservice.model.InvantoryItem;

@Repository
public interface InvantoryRepository extends MongoRepository<InvantoryItem, String> {
	//
}