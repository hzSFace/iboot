package com.sface.itransaction.service;

import com.sface.itransaction.domain.User;

public interface AccountService {

    void save(User user);

    void divZero(User user);

    void newDivZero(User user);

    void nestedDivZero(User user);

    /* 如下为REQUIRED嵌套事务 */
    void innerSaveDiff(User user);

    void innerSaveSame(User user);

    void innerSaveDiffNoCatch(User user);

    void innerSaveSameNoCatch(User user);

    /* 如下为REQUIRES_NEW嵌套事务 */
    void newInnerSaveDiff(User user);

    void newInnerSaveSame(User user);

    void newInnerSaveDiffNoCatch(User user);

    void newInnerSaveSameNoCatch(User user);

    /* 如下为NESTED嵌套事务 */
    void nestedInnerSaveDiff(User user);

    void nestedInnerSaveSame(User user);

    void nestedInnerSaveDiffNoCatch(User user);

    void nestedInnerSaveSameNoCatch(User user);
}
