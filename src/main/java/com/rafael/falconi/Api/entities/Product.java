package com.rafael.falconi.Api.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity()
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 20)
    private String name;

    @Column(length = 10)
    private String code;

    private double price;

    public Product() {
    }

    public Product(int id, String name, String code, double price) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(id, product.getId())
                && Objects.equals(name, product.getName())
                && Objects.equals(code, product.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
