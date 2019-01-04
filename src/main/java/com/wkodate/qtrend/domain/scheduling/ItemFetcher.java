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
    public Iterable<Item> fetchItems() {
        RestTemplate restTemplate = new RestTemplate();
        Item[] items = restTemplate.getForObject(
                host + endpoint + "?" + queryParameter, Item[].class);
        List<User> users = new ArrayList<>();
        List<Tag> tags = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            users.add(items[i].getUser());
            Tag[] t = items[i].getTags();
            tags.addAll(Arrays.asList(t));
        }
        LOG.info(items[0].toString());
        LOG.info(items[0].getTags()[0].toString());
        userService.saveAll(users);
        tagService.saveAll(tags);
        return itemService.saveAll(Arrays.asList(items));
    }

}
