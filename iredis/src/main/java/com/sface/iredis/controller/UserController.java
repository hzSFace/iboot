package com.sface.iredis.controller;

import com.sface.iredis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className UserController
 * @Desc 用户客户端
 * @Author HZ
 * @Date 2019/5/21 23:33
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/getUser")
    @Cacheable(value="user-key1")
    public User getUser() {
        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/inCre")
    public void inCre(){
        boolean exists = stringRedisTemplate.hasKey("inCre");
        if (exists) {
            stringRedisTemplate.opsForValue().increment("inCre");
        }else{
            stringRedisTemplate.opsForValue().set("inCre", "1");
        }
    }

    @RequestMapping("/getCre")
    public String getCre(){
        boolean exists = stringRedisTemplate.hasKey("inCre");
        if (exists) {
            return stringRedisTemplate.opsForValue().get("inCre");
        }else{
            return "0";
        }
    }
}
