package com.wkodate.technews.domain.scheduling;

import com.wkodate.technews.domain.model.Item;
import com.wkodate.technews.domain.service.ItemService;
import com.wkodate.technews.domain.service.TagService;
import com.wkodate.technews.domain.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbCleaner {

    private static final Logger LOG = LoggerFactory.getLogger(DbCleaner.class);

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

    //@Scheduled(cron = "${app.fetcher.cron}")
    public Iterable<Item> cleanItems() {
        return null;
    }

}
