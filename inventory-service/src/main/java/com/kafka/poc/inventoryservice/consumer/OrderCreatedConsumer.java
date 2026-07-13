package com.kafka.poc.inventoryservice.consumer;

import com.kafka.poc.events.inventory.InventoryReservedEvent;
import com.kafka.poc.events.order.OrderCreatedEvent;
import com.kafka.poc.inventoryservice.producer.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCreatedConsumer {

    private final KafkaProducerService producerService;

    @KafkaListener(
            topics = "order-created"
    )
    public void consume(OrderCreatedEvent event) {

        log.info("==================================");
        log.info("Order Received");
        log.info("Order Id : {}", event.getOrderId());
        log.info("Product  : {}", event.getProductName());
        log.info("Quantity : {}", event.getQuantity());
        log.info("==================================");

        // Simulate inventory reservation
        InventoryReservedEvent reservedEvent =
                new InventoryReservedEvent(
                        event.getOrderId(),
                        true
                );

        // Publish next event
        producerService.publishInventoryReservedEvent(reservedEvent);


        log.info("InventoryReservedEvent published successfully.");
    }
}