package com.example.demo.carts;

import com.example.demo.items.Items;
import com.example.demo.users.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Carts {

    @EmbeddedId
    private CartsKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Items items;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonBackReference // Prevents circular reference in serialization
    private Users users;

    private int quantity;

    // Getters and Setters

    public CartsKey getId() {
        return id;
    }

    public void setId(CartsKey id) {
        this.id = id;
    }

    public Items getItem() {
        return this.items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Users getUser() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
