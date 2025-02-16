package com.medium.kafka.repository;

import com.medium.kafka.dto.OrderDetails;
import com.medium.kafka.dto.OrderType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "OrderDetails")
public record StoreOrderEvent(@Id int orderId, OrderType orderType, OrderDetails orderDetails) {
}
