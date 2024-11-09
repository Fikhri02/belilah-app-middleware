package com.example.demo.orders;

import com.example.demo.addresses.Addresses;
import com.example.demo.ordersLine.OrdersLine;
import com.example.demo.users.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Orders {

    @Id
    @SequenceGenerator(
            name="orders_id_sequence",
            sequenceName = "orders_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orders_id_sequence"
    )

    private long id;
    private String trackingNo;
    private String orderId;
    private String status;
    private double totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addresses_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Addresses addresses;

    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<OrdersLine> ordersLine;

    //region Getters
    public long getId() {
        return id;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public Set<OrdersLine> getOrdersLine() {
        return ordersLine;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    //endregion


    //region Setters
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrdersLine(Set<OrdersLine> ordersLine) {
        this.ordersLine = ordersLine;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setAddresses(Addresses addresses)
    {
        this.addresses = addresses;
    }
    //endregion
}
