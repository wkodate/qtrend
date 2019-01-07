package com.wkodate.technews.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@ToString(exclude = {"item"})
@Entity
public class User {

    @Id
    private String id;

    @JsonProperty("permanent_id")
    private Long permanentId;

    @JsonProperty("facebook_id")
    private String facebookId;

    @JsonProperty("followees_count")
    private Integer followeesCount;

    @JsonProperty("followers_count")
    private Integer followersCount;

    @JsonProperty("girhub_login_name")
    private String githubLoginName;

    @JsonProperty("items_count")
    private Integer itemsCount;

    @JsonProperty("linkedin_id")
    private String linkedinId;

    private String location;

    private String name;

    @JsonProperty("profile_image_url")
    private String profileImageUrl;

    @JsonProperty("twitter_screen_name")
    private String twitterScreenName;

    @JsonProperty("website_url")
    private String websiteUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private List<Item> item;

}
