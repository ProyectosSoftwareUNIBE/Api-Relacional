package com.rafael.falconi.Api.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int amount;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "shoppingCart_id")
    private ShoppingCart shoppingCart;

    public Item(int id, int amount, Product product, ShoppingCart shoppingCart) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
