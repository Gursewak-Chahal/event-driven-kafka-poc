package com.kafka.poc.events.order;

import com.kafka.poc.events.common.EventType;
import com.kafka.poc.events.common.BaseEvent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderCreatedEvent extends BaseEvent{
    private Long orderId;

    private String productName;

    private Integer quantity;

    public OrderCreatedEvent(Long orderId,
                             String productName,
                             Integer quantity) {

        setEventType(EventType.ORDER_CREATED);

        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
    }
}
