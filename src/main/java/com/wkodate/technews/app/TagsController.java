package com.wkodate.technews.app;

import com.wkodate.technews.domain.model.Tag;
import com.wkodate.technews.domain.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TagsController {

    @Autowired
    private TagService tagService;

    public TagsController() {
    }

    @GetMapping("/tags")
    public Iterable<Tag> getTags() {
        return tagService.findAll();
    }

    @GetMapping("/tags/{id}")
    public Optional<Tag> getTag(@PathVariable Long id) {
        return tagService.findOne(id);
    }

}
