package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.User;
import com.klu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public User findByUsername(String username){
        return repo.findByUsername(username);
    }

    public User saveUser(User user){
        return repo.save(user);
    }
}