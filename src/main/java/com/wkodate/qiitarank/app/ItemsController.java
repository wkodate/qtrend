package com.wkodate.qiitarank.app;

import com.wkodate.qiitarank.domain.model.Item;
import com.wkodate.qiitarank.domain.repository.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemsController {

    private final ItemRepository itemRepository;

    public ItemsController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

    }

    @PostMapping("/items")
    public Item postItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PutMapping("/items/{id}")
    public Item putItem(@RequestBody Item newItem, @PathVariable Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setUser(newItem.getUser());
                    item.setUrl(newItem.getUrl());
                    item.setLikesCount(newItem.getLikesCount());
                    return itemRepository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return itemRepository.save(newItem);
                });
    }

    @DeleteMapping("/items/{id}")
    public void delete(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }

}
