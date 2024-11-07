package com.example.demo.carts;

import com.example.demo.items.Items;

public class CartsDTO {

    private CartsKey id;
    private int quantity;
    private Items items;

    CartsDTO(Carts carts){
        this.id = carts.getId();
        this.quantity = carts.getQuantity();
        this.items = carts.getItem();
    }

    public int getQuantity() {
        return quantity;
    }

    public CartsKey getId() {
        return id;
    }

    public Items getItems(){
        return items;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItems(Items items){
        this.items = items;
    }
}
