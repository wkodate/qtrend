package com.wkodate.qtrend.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Item {

    @Id
    private String id;

    private String title;

    @JsonProperty("comments_count")
    private String commentsCount;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("likes_count")
    private Integer likesCount;

    // TODO save tags
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item")
    @OrderColumn
    private List<Tag> tags;

    @JsonProperty("updated_at")
    private Date updatedAt;

    private String url;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private User user;

    @JsonProperty("page_views_count")
    private Integer pageViewsCount;


}
