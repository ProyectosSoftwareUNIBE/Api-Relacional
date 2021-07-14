package com.rafael.falconi.Api.controllers;

import com.rafael.falconi.Api.entities.Item;
import com.rafael.falconi.Api.entities.ShoppingCart;
import com.rafael.falconi.Api.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppinCartController {

    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppinCartController(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void createShoppingCart(ShoppingCart shoppingCart) {
        for (Item item:
             shoppingCart.getItems()) {
            item.setShoppingCart(shoppingCart);

        }
        this.shoppingCartRepository.save(shoppingCart);
    }
}
