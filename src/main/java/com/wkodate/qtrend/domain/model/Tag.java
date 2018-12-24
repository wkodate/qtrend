package com.wkodate.qtrend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String[] versions;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    @JsonIgnore
    private Item item;

}
