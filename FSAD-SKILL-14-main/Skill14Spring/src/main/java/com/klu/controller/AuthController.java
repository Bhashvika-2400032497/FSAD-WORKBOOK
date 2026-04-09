package com.klu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.klu.entity.User;
import com.klu.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService service;
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.register(user);
    }
    @PostMapping("/login")
    public User login(@RequestBody User user){
        return service.login(user.getEmail(),user.getPassword());
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return service.getUser(id);
    }
}