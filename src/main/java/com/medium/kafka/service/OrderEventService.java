package com.medium.kafka.service;

import com.medium.kafka.repository.StoreOrderEvent;
import com.medium.kafka.repository.OrderEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderEventService {
    private final OrderEventRepository repository;

    public Optional<StoreOrderEvent> getOrderById(int orderId) {
        return repository.findByOrderId(orderId);
    }
}
