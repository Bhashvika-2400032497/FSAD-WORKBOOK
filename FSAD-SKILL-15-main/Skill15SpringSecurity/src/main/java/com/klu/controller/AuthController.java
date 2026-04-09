package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.User;
import com.klu.security.JwtUtil;
import com.klu.service.UserService;

@RestController
public class AuthController {
    @Autowired
    UserService service;
    @Autowired
    JwtUtil jwtUtil;
    @PostMapping("/login")
    public String login(@RequestBody User user){
        User dbUser = service.findByUsername(user.getUsername());
        if(dbUser!=null && dbUser.getPassword().equals(user.getPassword())){

            return jwtUtil.generateToken(dbUser.getUsername(),dbUser.getRole());
        }
        return "Invalid Credentials";
    }
}