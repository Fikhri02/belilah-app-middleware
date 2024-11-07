package com.example.demo.carts;

import com.example.demo.items.Items;
import com.example.demo.items.ItemsRepository;
import com.example.demo.users.Users;
import com.example.demo.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartsService {

    CartsRepository cartsRepository;
    ItemsRepository itemsRepository;
    UsersRepository usersRepository;

    @Autowired
    public CartsService(CartsRepository cartsRepository, ItemsRepository itemsRepository, UsersRepository usersRepository){
        this.cartsRepository = cartsRepository;
        this.itemsRepository = itemsRepository;
        this.usersRepository = usersRepository;
    }

    @Transactional
    public List<Carts> addOrUpdateCart(List<Carts> carts){
        return carts.stream()
                .map(cart -> {
//                    if (cart.getItems() == null || cart.getItems().getId() == null) {
//                        throw new IllegalArgumentException("Item cannot be null or have a null ID");
//                    }

                    Items item = itemsRepository.findById(cart.getId().getItemId())
                            .orElseThrow(() -> new IllegalArgumentException("Item not found: " + cart.getId().getItemId()));

                    cart.setItems(item); // Ensure item is valid before saving cart

                    Users user = usersRepository.findById(cart.getId().getUserId())
                            .orElseThrow(() -> new IllegalArgumentException("User not found: " + cart.getId().getUserId()));
                    cart.setUsers(user);
                    return cartsRepository.save(cart);
                })
                .collect(Collectors.toList());// Collect and return the updated carts
    }
}

