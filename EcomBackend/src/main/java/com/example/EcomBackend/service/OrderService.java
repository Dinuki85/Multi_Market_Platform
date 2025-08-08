package com.example.EcomBackend.service;

import com.example.EcomBackend.model.Order;
import com.example.EcomBackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Create a new order
    public Order createOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());  // Set the order date to now
        order.setStatus(Order.OrderStatus.PENDING);  // Set status to PENDING initially
        return orderRepository.save(order);
    }

    // Update an existing order
    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setQuantity(updatedOrder.getQuantity());
            order.setStatus(updatedOrder.getStatus());
            order.setDeliveryDate(updatedOrder.getDeliveryDate());
            return orderRepository.save(order);
        }
        return null;  // Return null if the order does not exist
    }

    // Fetch all orders for a buyer
    public List<Order> getOrdersByBuyer(Long buyerId) {
        return orderRepository.findByBuyerId(buyerId);
    }

    // Fetch all orders for a product
    public List<Order> getOrdersByProduct(Long productId) {
        return orderRepository.findByProductId(productId);
    }

    // Fetch a single order by ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Delete an order
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
