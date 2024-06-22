package com.vrx.dinehub.orderservice.repo;

import com.vrx.dinehub.orderservice.entity.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Orders, String> {
}
