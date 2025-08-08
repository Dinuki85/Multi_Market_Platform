package com.example.EcomBackend.repository;

import com.example.EcomBackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByBuyerId(Long buyerId);  // Fetch orders by buyer
    List<Order> findByProductId(Long productId); // Fetch orders by product
    Optional<Order> findById(Long id);  // Fetch order by ID
}
