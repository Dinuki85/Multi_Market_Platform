package com.example.EcomBackend.controller;

import com.example.EcomBackend.model.Orders;
import com.example.EcomBackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Endpoint to create an order
    @PostMapping("/create")
    public Orders createOrder(@RequestBody Orders order) {
        return orderService.createOrder(order);
    }

    // Endpoint to update an order (e.g., status update, delivery date)
    @PutMapping("/update/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders order) {
        return orderService.updateOrder(id, order);
    }

    // Endpoint to get orders by buyer ID
    @GetMapping("/buyer/{buyerId}")
    public List<Orders> getOrdersByBuyer(@PathVariable Long buyerId) {
        return orderService.getOrdersByBuyer(buyerId);
    }

    // Endpoint to get orders by product ID
    @GetMapping("/product/{productId}")
    public List<Orders> getOrdersByProduct(@PathVariable Long productId) {
        return orderService.getOrdersByProduct(productId);
    }

    // Endpoint to get an order by ID
    @GetMapping("/{id}")
    public Optional<Orders> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Endpoint to delete an order
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
