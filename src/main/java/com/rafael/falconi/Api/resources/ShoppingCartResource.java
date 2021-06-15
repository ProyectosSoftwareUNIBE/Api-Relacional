package com.rafael.falconi.Api.resources;

import com.rafael.falconi.Api.controllers.ShoppinCartController;
import com.rafael.falconi.Api.entities.ShoppingCart;
import com.rafael.falconi.Api.resources.exceptions.ShoppingCartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ShoppingCartResource.SHOPPINGCART)
public class ShoppingCartResource {

    public static final String SHOPPINGCART = "/shoppingcart";

    private ShoppinCartController shoppinCartController;

    @Autowired
    public ShoppingCartResource(ShoppinCartController shoppinCartController) {
        this.shoppinCartController = shoppinCartController;
    }

    @PostMapping
    public ResponseEntity createShoppingCart(@RequestBody ShoppingCart shoppingCart) throws ShoppingCartException{
        try {
            this.shoppinCartController.createShoppingCart(shoppingCart);
            return new ResponseEntity("\" El pedido fue registrado\"", HttpStatus.ACCEPTED);
        }catch (Exception e){
            throw  new ShoppingCartException("Los datos enviados no son los correcots");
        }

    }

}
