package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.User;
import com.klu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public User register(User user){
        return repo.save(user);
    }

    public User login(String email,String password){
        return repo.findByEmailAndPassword(email,password);
    }

    public User getUser(Long id){
        return repo.findById(id).orElse(null);
    }
}