package com.medium.kafka.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderEventRepository extends MongoRepository <StoreOrderEvent, Integer> {
    Optional<StoreOrderEvent> findByOrderId(int orderId);
}
