package com.example.EcomBackend.controller;

import com.example.EcomBackend.model.Product;
import com.example.EcomBackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add a new product (Seller can use this)
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Get all products (For Buyers and Sellers)
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/name")

    public List<Product> findProductByName(@PathVariable("name") String name){
        return productService.getProductByName(name);
    }



    // Get products by category (For Buyers to filter products by category)
    @GetMapping
    public List<Product> getProductsByCategory(@RequestParam(required = false) String category) {
        if (category != null) {
            try {
                Product.Category productCategory = Product.Category.valueOf(category.toUpperCase());
                return productService.getProductsByCategory(productCategory);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid category: " + category);
            }
        }
        return productService.getAllProducts(); // If no category is provided, return all products
    }

    // Get a single product by ID
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Update a product (Seller can update their products)
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // Delete a product (Seller can delete their products)
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
