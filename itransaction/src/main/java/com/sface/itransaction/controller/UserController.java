package com.sface.itransaction.controller;

import com.sface.itransaction.domain.User;
import com.sface.itransaction.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className UserController
 * @Desc 用户操作
 * @Author HZ
 * @Date 2019/8/20 21:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User user = this.userService.findUserById(id);
        return user;
    }

    @RequestMapping("/save")
    public List<User> save(){
        User user = new User();
        user.setId(1l);
        user.setUserName("糖糖");
        this.userService.save(user);

        return userService.findAll();
    }

    @RequestMapping("/delete/{id}")
    public List<User> delete(@PathVariable Long id){
       this.userService.delete(id);

       return userService.findAll();
    }
}
