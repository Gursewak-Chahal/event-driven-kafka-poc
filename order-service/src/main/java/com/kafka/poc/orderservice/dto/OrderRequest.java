package com.kafka.poc.orderservice.dto;

import lombok.Data;

@Data
public class OrderRequest {

    private Long orderId;

    private String productName;

    private Integer quantity;
}
