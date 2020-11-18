package com.kaphaogame.account.controllers;

import com.kaphaogame.account.models.Order;
import com.kaphaogame.account.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

    OrderRepository orderRepository;

    public OrderRestController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAllOrder() {
        return orderRepository.getAllOrder();
    }

    @PostMapping
    public Order createOrder(Order order) throws ExecutionException, InterruptedException, IOException {
        return orderRepository.createOrder(order);
    }

    @GetMapping("/{orderName}")
    public List<Order> getAllOrderByOrderName(@PathVariable String orderName) {
        return orderRepository.getAllOrderByOrderName(orderName);
    }
}
