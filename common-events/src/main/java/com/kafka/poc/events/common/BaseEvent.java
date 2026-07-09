package com.kafka.poc.events.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Data
public class BaseEvent {
    private String eventId = UUID.randomUUID().toString();

    private Instant timestamp = Instant.now();

    private EventType eventType;
}
