package com.kafka.poc.notificationservice.consumer;

import com.kafka.poc.events.inventory.InventoryReservedEvent;
import com.kafka.poc.events.order.OrderCreatedEvent;
import com.kafka.poc.events.shipping.ShipmentCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationConsumer {

    @KafkaListener(
            topics = "order-created"
    )
    public void orderCreated(OrderCreatedEvent event) {

        log.info("==================================");
        log.info("Notification: Order Created");
        log.info("==================================");
    }

    @KafkaListener(
            topics = "inventory-reserved",
            groupId = "notification-group"
    )
    public void inventoryReserved(InventoryReservedEvent event) {

        log.info("==================================");
        log.info("Notification: Inventory Reserved");
        log.info("==================================");
    }

    @KafkaListener(
            topics = "shipment-created",
            groupId = "notification-group"
    )
    public void shipmentCreated(ShipmentCreatedEvent event) {

        log.info("==================================");
        log.info("Notification: Shipment Created");
        log.info("==================================");
    }

}