package com.example.demo.ordersLine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersLineService {

    OrdersLineRepository ordersLineRepository;

    @Autowired
    public OrdersLineService(OrdersLineRepository ordersLineRepository){
        this.ordersLineRepository = ordersLineRepository;
    }
}
