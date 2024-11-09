package com.example.demo.orders;

import com.example.demo.users.Users;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/orders")
public class OrdersController {
    private final OrdersService ordersService;

    OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
    }

    @CrossOrigin
    @PostMapping(path = "/create-order")
    public Orders CreateOrder(@RequestBody Users users){
        return ordersService.createOrdersFromCart(users);
    }
}
