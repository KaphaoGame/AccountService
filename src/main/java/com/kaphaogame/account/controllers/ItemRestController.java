package com.kaphaogame.account.controllers;

import com.kaphaogame.account.models.Item;
import com.kaphaogame.account.models.Order;
import com.kaphaogame.account.repository.ItemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {
    ItemRepository itemRepository;

    public ItemRestController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping
    public Item createItem(Item item) throws ExecutionException, InterruptedException, IOException {
        return itemRepository.createItem(item);
    }
}
