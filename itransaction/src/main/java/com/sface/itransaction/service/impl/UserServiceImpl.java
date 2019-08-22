package com.sface.itransaction.service.impl;

import com.sface.itransaction.domain.User;
import com.sface.itransaction.repository.UserRepository;
import com.sface.itransaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @className UserServiceImpl
 * @Desc TODO (这里用一句话描述这个类的作用)
 * @Author HZ
 * @Date 2019/8/20 21:44
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void divZero(User user) {
        int i = 10/0;
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void nestedDivZero(User user) {
        int i = 10/0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void newDivZero(User user) {
        int i = 10/0;
    }
}
