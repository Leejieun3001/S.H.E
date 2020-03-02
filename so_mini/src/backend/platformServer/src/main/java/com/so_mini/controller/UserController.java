package com.so_mini.controller;

import com.so_mini.domain.model.User;
import com.so_mini.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/test")
    public List<User> getUser(){
        return userRepository.findAll();
    }
    @RequestMapping("/test/{u_idx}")
    public User getUserById(@PathVariable("u_idx") long u_idx){
        return  userRepository.findById(u_idx).get();
    }
}
