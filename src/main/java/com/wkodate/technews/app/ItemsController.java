package com.wkodate.technews.app;

import com.wkodate.technews.domain.model.Item;
import com.wkodate.technews.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public Iterable<Item> getItems() {
        return itemService.findAll();
    }

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.findOne(id).orElseThrow(() -> new ItemNotFoundException(id));

    }

    @PostMapping("/items")
    public Item postItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/items/{id}")
    public Item putItem(@RequestBody Item newItem, @PathVariable Long id) {
        return itemService.findOne(id)
                .map(item -> {
                    item.setUser(newItem.getUser());
                    item.setUrl(newItem.getUrl());
                    item.setLikesCount(newItem.getLikesCount());
                    return itemService.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(String.valueOf(id));
                    return itemService.save(newItem);
                });
    }

    @DeleteMapping("/items/{id}")
    public void delete(@PathVariable Long id) {
        itemService.delete(id);
    }

    @PostMapping("/fetch")
    public Iterable<Item> fetchRequest() {
        return itemService.fetch();
    }

}
