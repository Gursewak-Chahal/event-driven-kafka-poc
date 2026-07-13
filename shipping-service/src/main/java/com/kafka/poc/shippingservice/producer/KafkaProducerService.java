package com.kafka.poc.shippingservice.producer;

import com.kafka.poc.events.shipping.ShipmentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private static final String SHIPMENT_CREATED_TOPIC = "shipment-created";

    private final KafkaTemplate<String, ShipmentCreatedEvent> kafkaTemplate;

    public void publishShipmentCreatedEvent(
            ShipmentCreatedEvent event) {

        kafkaTemplate.send(
                SHIPMENT_CREATED_TOPIC,
                event.getOrderId().toString(),
                event
        );
    }
}
