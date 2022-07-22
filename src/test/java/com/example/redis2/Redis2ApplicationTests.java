package com.example.redis2;

import com.example.redis2.domain.ResponeVo;
import com.example.redis2.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Redis2ApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        User user = new User("zhang", 12, new Date());
        redisTemplate.opsForValue().set("user",user);
        User user1 = (User)redisTemplate.opsForValue().get("user");
        System.out.println(user1);
    }
    @Test
    void Test2(){
        ResponeVo<List<User>> responeVo = new ResponeVo<>();
        List<User> userList = new ArrayList<>();
        userList.add(new User("zhang1", 12, new Date()));
        userList.add(new User("zhang2", 13, new Date()));
        userList.add(new User("zhang3", 14, new Date()));
        responeVo.setParam(userList);
        responeVo.setCount(userList.size()+"");
        redisTemplate.opsForValue().set("responeVo",responeVo);
        Object responeVo1 = redisTemplate.opsForValue().get("responeVo");
        System.out.println(responeVo1);
    }
}
