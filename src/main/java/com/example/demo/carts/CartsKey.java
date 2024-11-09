package com.example.demo.carts;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartsKey implements Serializable {

    private Long itemId;
    private Long userId;

    CartsKey(long itemId, long userId){
        this.itemId = itemId;
        this.userId = userId;
    }

    CartsKey(){};

    // Getters, Setters, equals, and hashCode methods

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartsKey cartsKey = (CartsKey) o;
        return Objects.equals(itemId, cartsKey.itemId) && Objects.equals(userId, cartsKey.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, userId);
    }
}
