package com.sface.itransaction.controller;

import com.sface.itransaction.domain.User;
import com.sface.itransaction.service.AccountService;
import com.sface.itransaction.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className TransactionController
 * @Desc 事务处理
 * @Author HZ
 * @Date 2019/8/21 22:40
 * @Version 1.0
 */
@RestController
@RequestMapping("/ts")
public class TransactionController {

    @Resource
    private AccountService accountService;

    @Resource
    private UserService userService;

    /**
     * 无事务方法调用不同实现类的两个REQUIRD方法
     * 开启两个事务
     * 方法2抛异常不影响方法1
     * */
    @RequestMapping("/saveDiff")
    public List<User> saveDiff(){
        User user = getUser();

        this.accountService.save(user);

        this.userService.divZero(user);

        return findAll();
    }

    /**
     * 无事务方法调用相同实现类的两个REQUIRD方法
     * 开启1个事务
     * 方法2抛异常不影响方法1
     * */
    @RequestMapping("/saveSame")
    public List<User> saveSame(){
        User user = getUser();

        this.accountService.save(user);

        this.accountService.divZero(user);

        return findAll();
    }

    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用另一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常，对方法2的异常进行捕获不抛出，会报"marking existing transaction as rollback-only"，影响方法1
     * */
    @RequestMapping("/innerSaveDiff")
    public List<User> innerSaveDiff(){
        User user = getUser();

        this.accountService.innerSaveDiff(user);

        return findAll();
    }


    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用同一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常，对方法2的异常进行捕获不抛出，不影响方法1
     * */
    @RequestMapping("/innerSaveSame")
    public List<User> innerSaveSame(){
        User user = getUser();

        this.accountService.innerSaveSame(user);

        return findAll();
    }

    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用另一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常影响方法1
     * */
    @RequestMapping("/innerSaveDiffNoCatch")
    public List<User> innerSaveDiffNoCatch(){
        User user = getUser();

        this.accountService.innerSaveDiffNoCatch(user);

        return findAll();
    }

    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用另一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常影响方法1
     * */
    @RequestMapping("/innerSaveSameNoCatch")
    public List<User> innerSaveSameNoCatch(){
        User user = getUser();

        this.accountService.innerSaveSameNoCatch(user);

        return findAll();
    }

    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用另一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常，对方法2的异常进行捕获不抛出，会报"marking existing transaction as rollback-only"，影响方法1
     * */
    @RequestMapping("/newInnerSaveDiff")
    public List<User> newInnerSaveDiff(){
        User user = getUser();

        this.accountService.newInnerSaveDiff(user);

        return findAll();
    }


    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用同一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常，对方法2的异常进行捕获不抛出，不影响方法1
     * */
    @RequestMapping("/newInnerSaveSame")
    public List<User> newInnerSaveSame(){
        User user = getUser();

        this.accountService.newInnerSaveSame(user);

        return findAll();
    }

    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用另一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常影响方法1
     * */
    @RequestMapping("/newInnerSaveDiffNoCatch")
    public List<User> newInnerSaveDiffNoCatch(){
        User user = getUser();

        this.accountService.newInnerSaveDiffNoCatch(user);

        return findAll();
    }

    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用另一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常影响方法1
     * */
    @RequestMapping("/newInnerSaveSameNoCatch")
    public List<User> newInnerSaveSameNoCatch(){
        User user = getUser();

        this.accountService.newInnerSaveSameNoCatch(user);

        return findAll();
    }

    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用另一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常，对方法2的异常进行捕获不抛出，会报"marking existing transaction as rollback-only"，影响方法1
     * */
    @RequestMapping("/nestedInnerSaveDiff")
    public List<User> nestedInnerSaveDiff(){
        User user = getUser();

        this.accountService.nestedInnerSaveDiff(user);

        return findAll();
    }


    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用同一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常，对方法2的异常进行捕获不抛出，不影响方法1
     * */
    @RequestMapping("/nestedInnerSaveSame")
    public List<User> nestedInnerSaveSame(){
        User user = getUser();

        this.accountService.newInnerSaveSame(user);

        return findAll();
    }

    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用另一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常影响方法1
     * */
    @RequestMapping("/nestedInnerSaveDiffNoCatch")
    public List<User> nestedInnerSaveDiffNoCatch(){
        User user = getUser();

        this.accountService.nestedInnerSaveDiffNoCatch(user);

        return findAll();
    }

    /**
     * 无事务方法REQUIRD方法，REQUIRD内部调用另一个SERVICE的REQUIRD方法
     * 开启1个事务
     * 方法2抛异常影响方法1
     * */
    @RequestMapping("/nestedInnerSaveSameNoCatch")
    public List<User> nestedInnerSaveSameNoCatch(){
        User user = getUser();

        this.accountService.nestedInnerSaveSameNoCatch(user);

        return findAll();
    }

    public User getUser(){
        User user = new User();
        user.setId(1l);
        user.setUserName("糖糖");
        return user;
    }


    public List<User> findAll(){
        return userService.findAll();
    }
}
