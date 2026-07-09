package com.kafka.poc.orderservice.producer;

import com.kafka.poc.events.order.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private static final String ORDER_CREATED_TOPIC = "order-created";

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void sendOrderCreatedEvent(OrderCreatedEvent event) {

        kafkaTemplate.send(
                ORDER_CREATED_TOPIC,
                event.getOrderId().toString(),
                event
        );

    }

}