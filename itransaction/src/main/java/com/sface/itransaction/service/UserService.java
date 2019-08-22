package com.sface.itransaction.service;

import com.sface.itransaction.domain.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);

    void save(User user);

    void delete(Long id);

    List<User> findAll();

    void divZero(User user);

    void newDivZero(User user);

    void nestedDivZero(User user);
}
