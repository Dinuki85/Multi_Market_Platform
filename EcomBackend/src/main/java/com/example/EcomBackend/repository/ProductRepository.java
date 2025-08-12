package com.example.EcomBackend.repository;

import com.example.EcomBackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategory(Product.Category category);

    @Query("select p from Product p where p.name = ?1")
    List<Product> findByName(String name);
}
