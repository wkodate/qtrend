package com.wkodate.qiitaranking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepository extends JpaRepository<Item, Long> {
}
