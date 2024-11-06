package com.example.demo.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/items")
public class ItemsController {

    private final ItemsService itemsService;

    @Autowired
    ItemsController(ItemsService itemsService)
    {
        this.itemsService = itemsService;
    }

    @CrossOrigin
    @GetMapping(path = "/get-all")
    public List<Items> getAllItems()
    {
        return itemsService.getAll();
    }

}
