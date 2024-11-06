package com.example.demo.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {

    ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    public List<Items> getAll(){
        return itemsRepository.findAll();
    }
}
