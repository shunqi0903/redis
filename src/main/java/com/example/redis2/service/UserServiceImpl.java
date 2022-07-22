package com.example.redis2.service;

import com.example.redis2.domain.ResponeVo;
import com.example.redis2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl {


    public ResponeVo<List<User>> getValue(){
        ResponeVo<List<User>> responeVo = new ResponeVo<>();
        List<User> userList = getUserList();
        responeVo.setParam(userList);
        responeVo.setCount(userList.size()+"");
        return responeVo;
    }
    private List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("zhang1", 12, new Date()));
        userList.add(new User("zhang2", 13, new Date()));
        userList.add(new User("zhang3", 14, new Date()));

        return userList;
    }
}
