package com.example.demo.orders;

import com.example.demo.addresses.Addresses;
import com.example.demo.addresses.AddressesRepository;
import com.example.demo.carts.Carts;
import com.example.demo.items.Items;
import com.example.demo.ordersLine.OrdersLine;
import com.example.demo.users.Users;
import com.example.demo.users.UsersRepository;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.security.SecureRandom;


@Service
public class OrdersService {

    OrdersRepository ordersRepository;
    UsersRepository usersRepository;
    AddressesRepository addressesRepository;

    public OrdersService(OrdersRepository ordersRepository, UsersRepository usersRepository, AddressesRepository addressesRepository){
        this.ordersRepository = ordersRepository;
        this.usersRepository = usersRepository;
        this.addressesRepository = addressesRepository;
    }

    public Orders createOrdersFromCart(Users users){

        users = usersRepository.findCartsById(users.getId()).orElseThrow(() -> new IllegalStateException("User Not Found"));

        Set<OrdersLine> ordersLineSet = new HashSet<>();

        for (Carts carts : users.getCarts()) {
            OrdersLine ordersLine = new OrdersLine();

            ordersLine.setItemDesc(carts.getItem().getDescription());
            ordersLine.setUnitPrice(carts.getItem().getUnitPrice());
            ordersLine.setQuantity(carts.getQuantity());
            ordersLine.setTotalAmount(ordersLine.getQuantity() * ordersLine.getUnitPrice());

            ordersLineSet.add(ordersLine);
        }

        Orders orders = new Orders();
        Pageable pageable = PageRequest.of(0, 1);

        Addresses address = addressesRepository.findTopByUsersIdAndIsActiveTrue(users.getId()).orElseThrow(()->new IllegalStateException("Active address not found"));

        orders.setAddresses(address);
        orders.setOrdersLine(ordersLineSet);
        orders.setUsers(users);
        orders.setStatus("PLACED");
        orders.setOrderId(generateRandomKey(8));
        orders.setTrackingNo(generateRandomKey(4));
        ordersRepository.save(orders);
        return orders;
    }

    private String generateRandomKey(int length) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }

}
