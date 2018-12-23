package com.wkodate.qtrend.domain.scheduling;

import com.wkodate.qtrend.domain.model.Item;
import com.wkodate.qtrend.domain.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class ItemFetcher {

    private static final Logger LOG = LoggerFactory.getLogger(ItemFetcher.class);

    @Autowired
    ItemService itemService;

    @Value("${app.fetcher.host}")
    private String host;

    @Value("${app.fetcher.endpoint}")
    private String endpoint = "/api/v2/items";

    @Value("${app.fetcher.query_parameter}")
    private String queryParameter = "?page=1&per_page=20";

    @Scheduled(cron = "${app.fetcher.cron}")
    public void fetchItems() {
        RestTemplate restTemplate = new RestTemplate();
        Item[] item = restTemplate.getForObject(host + endpoint + "?" + queryParameter, Item[].class);
        itemService.saveAll(Arrays.asList(item));
    }

}
