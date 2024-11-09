package com.example.demo.carts;

import com.example.demo.items.Items;
import com.example.demo.items.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/carts")
public class CartController {

    private final CartsService cartsService;

    @Autowired
    CartController(CartsService cartsService)
    {
        this.cartsService = cartsService;
    }
//
    @CrossOrigin
    @PostMapping(path = "/upsert-carts")
    public List<Carts> upsertCarts(@RequestBody List<Carts> carts)
    {
        return cartsService.addOrUpdateCart(carts);
    }

    @CrossOrigin
    @DeleteMapping("/delete-by-key/{itemId}/{userId}")
    public ResponseEntity<String> deleteCart(@PathVariable Long itemId, @PathVariable Long userId) {
        cartsService.deleteCartById(itemId, userId);
        return ResponseEntity.ok("Cart deleted successfully");
    }
}
