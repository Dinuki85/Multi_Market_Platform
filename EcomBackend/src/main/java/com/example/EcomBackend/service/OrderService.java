package com.example.EcomBackend.service;

import com.example.EcomBackend.model.Orders;
import com.example.EcomBackend.model.Orders;
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
    public Orders createOrder(Orders order) {
        order.setOrderDate(LocalDateTime.now());  // Set the order date to now
        order.setStatus(Orders.OrderStatus.PENDING);  // Set status to PENDING initially
        return orderRepository.save(order);
    }

    // Update an existing order
    public Orders updateOrder(Long id, Orders updatedOrder) {
        Optional<Orders> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Orders order = existingOrder.get();
            order.setQuantity(updatedOrder.getQuantity());
            order.setStatus(updatedOrder.getStatus());
            order.setDeliveryDate(updatedOrder.getDeliveryDate());
            return orderRepository.save(order);
        }
        return null;  // Return null if the order does not exist
    }

    // Fetch all orders for a buyer
    public List<Orders> getOrdersByBuyer(Long buyerId) {
        return orderRepository.findByBuyerId(buyerId);
    }

    // Fetch all orders for a product
    public List<Orders> getOrdersByProduct(Long productId) {
        return orderRepository.findByProductId(productId);
    }

    // Fetch a single order by ID
    public Optional<Orders> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Delete an order
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
