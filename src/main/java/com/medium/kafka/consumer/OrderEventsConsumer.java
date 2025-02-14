package com.medium.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medium.kafka.repository.StoreOrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderEventsConsumer {

    public final ObjectMapper objectMapper;
    public final MongoTemplate mongoTemplate;

    @KafkaListener(topics = {"order-event"})
    public void onMessage(ConsumerRecord<Integer, String> message) throws JsonProcessingException {

        log.info("Message Received: {}", message);
        final StoreOrderEvent storeOrderEvent = objectMapper.readValue(message.value(), StoreOrderEvent.class);
        log.info("Converted message in Java Object: {}", storeOrderEvent);
        final StoreOrderEvent save = mongoTemplate.save(storeOrderEvent);
        log.info("Message successfully persisted to mongoDB with orderId: {}", save.orderId());

    }
}
