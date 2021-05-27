package com.rafael.falconi.Api.entities;

import javax.persistence.*;
import java.util.List;


@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "shoppingCart")
    private List<Item> items;


}
