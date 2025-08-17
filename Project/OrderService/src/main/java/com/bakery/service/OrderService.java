package com.bakery.service;

import com.bakery.entities.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
    public Order getOrdersById(Long id);
    public Order addOrder(Order order);
    public void deleteOrder(Long id);
}