package com.wkodate.qtrend.app;

import com.wkodate.qtrend.domain.model.Item;
import com.wkodate.qtrend.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankingController {

    @Autowired
    private ItemService itemService;

    public RankingController() {
    }

    @GetMapping("/")
    public Iterable<Item> getLikesRanking() {
        return itemService.sortByLikes();
    }

}
