package com.wkodate.technews.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Tag {

    @Id
    @Column(length = 191)
    private String name;

    @Column(length = 191)
    private String[] versions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Item> items;

}
