package com.rafael.falconi.Api.repositories;

import com.rafael.falconi.Api.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,String> {
}
