package com.wkodate.qiitarank.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
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

}
