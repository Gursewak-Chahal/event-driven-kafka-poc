package com.kafka.poc.events.shipping;

import com.kafka.poc.events.common.BaseEvent;
import com.kafka.poc.events.common.EventType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShipmentCreatedEvent extends BaseEvent {

    private Long orderId;

    private String status;

    public ShipmentCreatedEvent(Long orderId,
                                String status) {

        setEventType(EventType.SHIPMENT_CREATED);

        this.orderId = orderId;
        this.status = status;
    }
}