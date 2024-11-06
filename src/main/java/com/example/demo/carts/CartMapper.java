package com.example.demo.carts;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class CartMapper {
//    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    public static CartsDTO cartsToCartDTO(Carts carts){
        return new CartsDTO(carts);
    }

    public static Set<CartsDTO> cartsToCartDTO(Set<Carts> carts){
        Set<CartsDTO> cartsDTO = new HashSet<>();
        for(Carts cart : carts){
            CartsDTO cartDTO = new CartsDTO(cart);
            cartsDTO.add(cartDTO);
        }
        return cartsDTO;
    }
}
