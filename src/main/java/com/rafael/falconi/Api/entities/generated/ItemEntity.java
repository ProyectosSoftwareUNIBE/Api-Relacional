package com.rafael.falconi.Api.entities.generated;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item", schema = "public", catalog = "tienda")
public class ItemEntity {
    private int id;
    private int amount;
    private ProductEntity productByProductId;
    private ShoppingCartEntity shoppingCartByShoppingCartId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return id == that.id && amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
    public ShoppingCartEntity getShoppingCartByShoppingCartId() {
        return shoppingCartByShoppingCartId;
    }

    public void setShoppingCartByShoppingCartId(ShoppingCartEntity shoppingCartByShoppingCartId) {
        this.shoppingCartByShoppingCartId = shoppingCartByShoppingCartId;
    }
}
