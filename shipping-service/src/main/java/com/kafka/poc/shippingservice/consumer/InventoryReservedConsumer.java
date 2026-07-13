package com.kafka.poc.shippingservice.consumer;

import com.kafka.poc.events.inventory.InventoryReservedEvent;
import com.kafka.poc.events.shipping.ShipmentCreatedEvent;
import com.kafka.poc.shippingservice.producer.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryReservedConsumer {

    private final KafkaProducerService producer;

    @KafkaListener(
            topics = "inventory-reserved"
    )
    public void consume(
            InventoryReservedEvent event) {

        log.info("==============================");
        log.info("Inventory Reserved");
        log.info("Order Id : {}", event.getOrderId());
        log.info("==============================");

        ShipmentCreatedEvent shipment =
                new ShipmentCreatedEvent(
                        event.getOrderId(),
                        "READY_FOR_SHIPMENT"
                );

        producer.publishShipmentCreatedEvent(shipment);

        log.info("ShipmentCreatedEvent Published");
    }
}