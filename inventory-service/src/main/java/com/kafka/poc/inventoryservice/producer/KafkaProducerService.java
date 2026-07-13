package com.kafka.poc.inventoryservice.producer;

import com.kafka.poc.events.inventory.InventoryReservedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private static final String INVENTORY_RESERVED_TOPIC = "inventory-reserved";

    private final KafkaTemplate<String, InventoryReservedEvent> kafkaTemplate;

    public void publishInventoryReservedEvent(InventoryReservedEvent event) {

        kafkaTemplate.send(
                INVENTORY_RESERVED_TOPIC,
                event.getOrderId().toString(),
                event
        );
    }
}