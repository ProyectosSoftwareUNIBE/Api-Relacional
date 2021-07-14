package com.rafael.falconi.Api.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private int amount;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    public Item(String id, int amount, Product product, ShoppingCart shoppingCart) {
        this.id = id;
        this.amount = amount;
        this.product = product;
        this.shoppingCart = shoppingCart;
    }

    public Item() {

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return Objects.equals(id, product.getId())
                && Objects.equals(amount, item.getAmount())
                && Objects.equals(product, item.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
