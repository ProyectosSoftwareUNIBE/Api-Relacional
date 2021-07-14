package com.rafael.falconi.Api.resources;

import com.rafael.falconi.Api.entities.Item;
import com.rafael.falconi.Api.entities.Product;
import com.rafael.falconi.Api.entities.ShoppingCart;
import com.rafael.falconi.Api.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShoppingCartResourceTest {

    @Autowired
    private RestService restService;

    private ShoppingCart shoppingCart;

    @Before
    public void Before(){
        this.shoppingCart=new ShoppingCart();
        List<Item> items=new ArrayList<Item>();
        Product product=new Product();
        product.setId("87703f20-a9a6-45dc-9eee-8684a37e8feb");
        Item item=new Item();
        item.setAmount(1);
        item.setProduct(product);
        items.add(item);
        User user= new User();
        user.setId("6da652d1-b9a7-44ef-8f50-31771b2e5efe");
        this.shoppingCart.setItems(items);
        this.shoppingCart.setUser(user);
    }
    @Test
    public void createShoppingCart() {
        String json=
                restService.restBuilder(new RestBuilder<String>().clazz(String.class))
                        .path(ShoppingCartResource.SHOPPINGCART)
                        .body(this.shoppingCart).post().build();
        System.out.println(json);
    }
}