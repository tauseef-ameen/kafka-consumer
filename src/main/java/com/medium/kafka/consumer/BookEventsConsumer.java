package com.medium.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookEventsConsumer {
    @KafkaListener(topics = {"book_event"})
    public void onMessage(ConsumerRecord<Integer, String> message) {
        log.info("onMessage: {}", message);
    }
}
