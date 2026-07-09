package com.kafka.poc.orderservice.controller;

import com.kafka.poc.orderservice.dto.OrderRequest;
import com.kafka.poc.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(
            @Valid @RequestBody OrderRequest request) {

        orderService.createOrder(request);

        return ResponseEntity.ok("Order event published successfully.");
    }
}