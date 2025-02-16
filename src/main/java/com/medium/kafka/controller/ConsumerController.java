package com.medium.kafka.controller;

import com.medium.kafka.repository.StoreOrderEvent;
import com.medium.kafka.service.OrderEventService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ConsumerController {
    private final OrderEventService service;

    @GetMapping("/v1/order/{orderId}")
    @Operation(summary="fetch kafka message from mongo db", description="Fetch Order Event from MongoDB")
    public ResponseEntity<StoreOrderEvent> fetchOrderDetails(@PathVariable int orderId) {

        log.info("calling mongo db service for orderId: {}", orderId);
        Optional<StoreOrderEvent> order = service.getOrderById(orderId);
        log.info("orderId :{} is: {}", orderId, order.isPresent());
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
