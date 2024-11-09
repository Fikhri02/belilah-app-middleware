package com.example.demo.ordersLine;

import com.example.demo.orders.Orders;
import com.example.demo.users.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table
public class OrdersLine {

    @Id
    @SequenceGenerator(
            name="orders_line_id_sequence",
            sequenceName = "orders_line_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orders_line_id_sequence"
    )


    private long id;
    private String itemDesc;
    private int quantity;
    private double unitPrice;
    private double totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference
    private Orders orders;



    //region Getters
    public long getId() {
        return id;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Orders getOrders() {
        return orders;
    }
    //endregion


    //region Setters
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    //endregion
}
