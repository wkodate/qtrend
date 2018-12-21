package com.wkodate.qtrend.domain.service;

import com.wkodate.qtrend.domain.model.Item;
import com.wkodate.qtrend.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findOne(Long id) {
        return itemRepository.findById(id);
    }

    public Item save(Item rss) {
        return itemRepository.save(rss);
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

}
