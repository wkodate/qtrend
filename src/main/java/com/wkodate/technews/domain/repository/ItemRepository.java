package com.wkodate.technews.domain.repository;

import com.wkodate.technews.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findTop10AllByOrderByLikesCountDesc();

    List<Item> findAllByOrderByLikesCountDesc();
}
