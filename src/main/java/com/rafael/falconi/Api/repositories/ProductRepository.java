package com.rafael.falconi.Api.repositories;

import com.rafael.falconi.Api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
