package com.bakery.controller;

import com.bakery.entities.Order;
import com.bakery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> getAll(){
        return ResponseEntity.ok(service.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getOrdersById(id));
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        Order saveOrder = service.addOrder(order);
        return ResponseEntity.ok(saveOrder);
    }
}