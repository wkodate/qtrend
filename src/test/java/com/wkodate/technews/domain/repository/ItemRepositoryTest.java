package com.wkodate.technews.domain.repository;

import com.wkodate.technews.domain.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    private static final String ID1 = "1";
    private static final String TITLE1 = "today's news";
    private static final String URL1 = "localhost";
    private static final int LIKES_COUNT1 = 3;
    private static final String ID2 = "2";
    private static final String TITLE2 = "my favorite device";
    private static final String URL2 = "localhost";
    private static final int LIKES_COUNT2 = 5;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void name() {
    }

    @Before
    public void setUp() throws Exception {
        Item item1 = new Item();
        item1.setId(ID1);
        item1.setTitle(TITLE1);
        item1.setUrl(URL1);
        item1.setLikesCount(LIKES_COUNT1);
        Item item2 = new Item();
        item2.setId(ID2);
        item2.setTitle(TITLE2);
        item2.setUrl(URL2);
        item2.setLikesCount(LIKES_COUNT2);
        this.entityManager.persist(item1);
        this.entityManager.persist(item2);
    }

    @Test
    public void itemTest() throws Exception {
        List<Item> items = this.itemRepository.findTop10AllByOrderByLikesCountDesc();
        assertThat(items.get(0).getId()).isEqualTo(ID2);
        assertThat(items.get(0).getTitle()).isEqualTo(TITLE2);
        assertThat(items.get(0).getUrl()).isEqualTo(URL2);
        assertThat(items.get(0).getLikesCount()).isEqualTo(LIKES_COUNT2);
    }


}