package com.rafael.falconi.Api.controllers;

import com.rafael.falconi.Api.entities.Product;
import com.rafael.falconi.Api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    public Optional<Product> findProductById(int id) {
        return this.productRepository.findById(id);
    }

    public List<Product> findProductByCategory(String category) {
        return this.productRepository.findProductsByCategory(category);
    }

    public void createProduct(Product product) {
        this.productRepository.save(product);
    }
}
