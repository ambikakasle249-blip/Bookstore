package com.bookstore.controller;

import com.bookstore.model.Order;
import com.bookstore.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {

        return orderRepository.save(order);
    }
}
