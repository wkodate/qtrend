package com.wkodate.qtrend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private Long permanentId;

    private String facebookId;

    private Integer followeesCount;

    private Integer followersCount;

    private String githubLoginName;

    private String id;

    private Integer itemCount;

    private Integer linkedinId;

    private String location;

    private String name;

    private String organization;

    private String profileImageUrl;

    private String twitterScreenName;

    private String websiteUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private List<Item> item;

}
