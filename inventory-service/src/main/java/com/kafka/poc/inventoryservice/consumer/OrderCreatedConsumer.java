package com.kafka.poc.inventoryservice.consumer;

import com.kafka.poc.events.order.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderCreatedConsumer {

    @KafkaListener(
            topics = "order-created",
            groupId = "inventory-group"
    )
    public void consume(OrderCreatedEvent event) {

        log.info("==================================");
        log.info("Order Received");
        log.info("Order Id : {}", event.getOrderId());
        log.info("Product  : {}", event.getProductName());
        log.info("Quantity : {}", event.getQuantity());
        log.info("==================================");

    }

}