package com.wkodate.technews.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@ToString(exclude = {"user"})
@Entity
public class Item {

    @Id
    @Column
    private String id;

    @Column
    private String title;

    @JsonProperty("comments_count")
    @Column
    private String commentsCount;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("likes_count")
    private Integer likesCount;

    @ManyToMany(cascade = CascadeType.ALL)
    @OrderColumn
    @JoinColumn
    private Tag[] tags;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @Column
    private String url;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private User user;

    @JsonProperty("page_views_count")
    private Integer pageViewsCount;


}
