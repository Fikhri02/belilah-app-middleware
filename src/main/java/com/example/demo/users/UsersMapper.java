package com.example.demo.users;

import com.example.demo.carts.CartMapper;
import com.example.demo.carts.Carts;
import com.example.demo.carts.CartsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public class UsersMapper {

    static UsersDTO usersToUsersDTO(Users users){
        return new UsersDTO(users, users.getCarts());
    }
}
