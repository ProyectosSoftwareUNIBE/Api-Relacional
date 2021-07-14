package com.rafael.falconi.Api.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Item> items;

    public ShoppingCart() {
    }

    public ShoppingCart(int id, User user, List<Item> items) {
        this.id = id;
        this.user = user;
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return id == that.id && Objects.equals(user, that.user) && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, items);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        if(item==null){
            return;
        }else{
            if(items==null){
                items=new ArrayList<Item>();
            }else {
                items.add(item);
                item.setShoppingCart(this);
            }
        }
    }
}
