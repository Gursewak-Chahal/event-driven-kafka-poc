package com.kafka.poc.orderservice.service;

import com.kafka.poc.events.order.OrderCreatedEvent;
import com.kafka.poc.orderservice.dto.OrderRequest;
import com.kafka.poc.orderservice.producer.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final KafkaProducerService kafkaProducerService;

    public void createOrder(OrderRequest request) {

        OrderCreatedEvent event = new OrderCreatedEvent(
                request.getOrderId(),
                request.getProductName(),
                request.getQuantity()
        );

        kafkaProducerService.sendOrderCreatedEvent(event);
    }
}