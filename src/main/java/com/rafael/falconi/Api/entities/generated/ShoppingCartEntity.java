package com.rafael.falconi.Api.entities.generated;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shopping_cart", schema = "public", catalog = "tienda")
public class ShoppingCartEntity {
    private int id;
    private List<ItemEntity> itemsById;
    private UserStoreEntity userStoreByUserId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartEntity that = (ShoppingCartEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @OneToMany(mappedBy = "shoppingCartByShoppingCartId")
    public List<ItemEntity> getItemsById() {
        return itemsById;
    }

    public void setItemsById(List<ItemEntity> itemsById) {
        this.itemsById = itemsById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserStoreEntity getUserStoreByUserId() {
        return userStoreByUserId;
    }

    public void setUserStoreByUserId(UserStoreEntity userStoreByUserId) {
        this.userStoreByUserId = userStoreByUserId;
    }
}
