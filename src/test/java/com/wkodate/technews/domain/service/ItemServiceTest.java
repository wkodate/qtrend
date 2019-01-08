package com.wkodate.technews.domain.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Test
    public void sortByLikesTest() {
        assertThat(itemService.sortByLikes()).isNotNull();
    }

    @Test
    public void sortDailyByLikesTest() {
        assertThat(itemService.sortDailyByLikes()).isNotNull();
    }

}