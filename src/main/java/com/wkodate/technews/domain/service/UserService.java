package com.wkodate.technews.domain.service;

import com.wkodate.technews.domain.model.User;
import com.wkodate.technews.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> saveAll(Iterable<User> user) {
        return userRepository.saveAll(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
