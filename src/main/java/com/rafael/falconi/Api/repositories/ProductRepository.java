package com.rafael.falconi.Api.repositories;

import com.rafael.falconi.Api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductsByCategory(String category);
}
