package com.rafael.falconi.Api.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity()
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 20)
    private String name;

    @Column(length = 10)
    private String code;

    private String image;

    private double price;

    @Column(length = 20)
    private String category;

    public Product() {
    }

    public Product(String id, String name, String code, String image, double price, String category) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.image = image;
        this.price = price;
        this.category = category;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
