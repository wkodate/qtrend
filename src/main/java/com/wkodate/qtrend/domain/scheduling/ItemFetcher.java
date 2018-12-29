package com.wkodate.qtrend.domain.scheduling;

import com.wkodate.qtrend.domain.model.Item;
import com.wkodate.qtrend.domain.model.Tag;
import com.wkodate.qtrend.domain.model.User;
import com.wkodate.qtrend.domain.service.ItemService;
import com.wkodate.qtrend.domain.service.TagService;
import com.wkodate.qtrend.domain.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ItemFetcher {

    private static final Logger LOG = LoggerFactory.getLogger(ItemFetcher.class);

    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;
    @Autowired
    private TagService tagService;

    @Value("${app.fetcher.host}")
    private String host;

    @Value("${app.fetcher.endpoint}")
    private String endpoint;

    @Value("${app.fetcher.query_parameter}")
    private String queryParameter;

    @Scheduled(cron = "${app.fetcher.cron}")
    public void fetchItems() {
        RestTemplate restTemplate = new RestTemplate();
        Item[] item = restTemplate.getForObject(
                host + endpoint + "?" + queryParameter, Item[].class);
        List<User> users = new ArrayList<>();
        List<Tag> tags = new ArrayList<>();
        for (int i = 0; i < item.length; i++) {
            users.add(item[i].getUser());
            Tag[] t = item[i].getTags();
            tags.addAll(Arrays.asList(t));
        }
        System.out.println(item[0].toString());
        System.out.println(item[0].getTags()[0].toString());
        userService.saveAll(users);
        itemService.save(item[0]);
        tagService.saveAll(tags);
    }

}
