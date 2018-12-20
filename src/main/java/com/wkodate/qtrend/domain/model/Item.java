package com.wkodate.qtrend.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    private String id;

    private String title;

    private String commentsCount;

    private Date createdAt;

    private Integer likesCount;

    @OneToMany
    private List<Tag> tags;

    private Date updatedAt;

    private String url;

    @ManyToOne
    private User user;

    private Integer pageViewCount;


}
