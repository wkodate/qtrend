package com.wkodate.qiitarank.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String url;
    private String user;
    private Long likesCount;

    public Item() {
    }

    public Item(String url, String user, Long likesCount) {
        this.url = url;
        this.user = user;
        this.likesCount = likesCount;
    }
}
