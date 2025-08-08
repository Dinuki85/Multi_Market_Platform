package com.example.EcomBackend.service;

import com.example.EcomBackend.model.Product;
import com.example.EcomBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //Add new product
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    //update a product
    public Product updateProduct(Long id,Product product){
        if(productRepository.existsById(id)){
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    //delete product
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    //get All product
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //get a single product by id
    public Product getProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

}
