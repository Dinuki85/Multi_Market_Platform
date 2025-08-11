package com.example.EcomBackend.repository;

import com.example.EcomBackend.model.Orders;
import com.example.EcomBackend.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByBuyerId(Long buyerId);  // Fetch orders by buyer
    List<Orders> findByProductId(Long productId); // Fetch orders by product
    Optional<Orders> findById(Long id);  // Fetch order by ID
}
