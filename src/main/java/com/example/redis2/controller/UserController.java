package com.example.redis2.controller;


import com.example.redis2.domain.ResponeVo;
import com.example.redis2.domain.User;
import com.example.redis2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getVlaue")
    @Cacheable(value = "userlist" ,key = "#root.methodName")
    public ResponeVo<List<User>> getValue(){
        return userService.getValue();
    }
}
