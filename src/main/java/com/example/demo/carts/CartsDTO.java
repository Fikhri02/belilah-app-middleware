package com.example.demo.carts;

import com.example.demo.items.Items;

public class CartsDTO {

    private Long id;
    private int quantity;
    private Items items;

    CartsDTO(Carts carts){
        this.quantity = carts.getQuantity();
        this.items = carts.getItem();
    }

    public int getQuantity() {
        return quantity;
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
