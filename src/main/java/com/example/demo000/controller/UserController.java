package com.example.demo000.controller;

import com.example.demo000.entity.User;
import com.example.demo000.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserMapper userMapper;

    //登录
    @RequestMapping("/login")
    public User login(@RequestBody User user) {
        return userMapper.Login(user);
    }
}
