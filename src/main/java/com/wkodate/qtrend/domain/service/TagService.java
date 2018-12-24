package com.wkodate.qtrend.domain.service;

import com.wkodate.qtrend.domain.model.Tag;
import com.wkodate.qtrend.domain.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public Iterable<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Optional<Tag> findOne(Long id) {
        return tagRepository.findById(id);
    }

    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    public List<Tag> saveAll(Iterable<Tag> tag) {
        return tagRepository.saveAll(tag);
    }

    public void delete(Long id) {
        tagRepository.deleteById(id);
    }

}
