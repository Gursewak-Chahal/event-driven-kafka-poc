package com.kafka.poc.events.inventory;

import com.kafka.poc.events.common.BaseEvent;
import com.kafka.poc.events.common.EventType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InventoryReservedEvent extends BaseEvent {
    private Long orderId;

    private boolean reserved;

    public InventoryReservedEvent(Long orderId,
                                  boolean reserved) {

        setEventType(EventType.INVENTORY_RESERVED);

        this.orderId = orderId;
        this.reserved = reserved;
    }
}
