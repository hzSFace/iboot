package com.sface.itransaction.service.impl;

import com.sface.itransaction.domain.User;
import com.sface.itransaction.repository.UserRepository;
import com.sface.itransaction.service.AccountService;
import com.sface.itransaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @className AccountService1Impl
 * @Desc 账务业务类
 * @Author HZ
 * @Date 2019/8/21 22:37
 * @Version 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Resource
    private UserService userService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(User user) {
        userRepository.save(user);
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void innerSaveDiff(User user) {
        userRepository.save(user);
        try {
            this.userService.divZero(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void innerSaveSame(User user) {
        userRepository.save(user);

       try {
           this.divZero(user);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void innerSaveDiffNoCatch(User user) {
        userRepository.save(user);
        this.userService.divZero(user);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void innerSaveSameNoCatch(User user) {
        userRepository.save(user);
        this.divZero(user);
    }

    //Creating new transaction with name [com.sface.itransaction.service.impl.AccountServiceImpl.newInnerSaveDiff]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void newInnerSaveDiff(User user) {
        //Participating in existing transaction
        userRepository.save(user);
        try {
            //uspending current transaction, creating new transaction
            this.userService.newDivZero(user);
            //Initiating transaction rollback
            //Resuming suspended transaction after completion of inner transaction
        }catch (Exception e){
            e.printStackTrace();
        }
        //Initiating transaction commit
    }
    //Creating new transaction with name [com.sface.itransaction.service.impl.AccountServiceImpl.newInnerSaveSame]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void newInnerSaveSame(User user) {
        //Participating in existing transaction
        userRepository.save(user);

        try {
            this.newDivZero(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        //Initiating transaction commit
    }

    //Creating new transaction with name [com.sface.itransaction.service.impl.AccountServiceImpl.newInnerSaveDiffNoCatch]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void newInnerSaveDiffNoCatch(User user) {
        //Participating in existing transaction
        userRepository.save(user);
        //uspending current transaction, creating new transaction
        this.userService.newDivZero(user);
        //Initiating transaction rollback
        //Resuming suspended transaction after completion of inner transaction
        //Initiating transaction rollback
    }

    //Creating new transaction with name [com.sface.itransaction.service.impl.AccountServiceImpl.newInnerSaveSameNoCatch]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void newInnerSaveSameNoCatch(User user) {
        //Participating in existing transaction
        userRepository.save(user);
        this.newDivZero(user);
        //Initiating transaction rollback
    }
    //
    //Creating new transaction with name [com.sface.itransaction.service.impl.AccountServiceImpl.nestedInnerSaveDiff]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void nestedInnerSaveDiff(User user) {
        //Participating in existing transaction
        userRepository.save(user);
        try {
            //Creating nested transaction with name [com.sface.itransaction.service.impl.UserServiceImpl.nestedDivZero]
            this.userService.nestedDivZero(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        //Initiating transaction commit
    }
    //Creating new transaction with name [com.sface.itransaction.service.impl.AccountServiceImpl.nestedInnerSaveSame]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void nestedInnerSaveSame(User user) {
        //Participating in existing transaction
        userRepository.save(user);

        try {
            this.nestedDivZero(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        //Initiating transaction commit
    }

    //Creating new transaction with name [com.sface.itransaction.service.impl.AccountServiceImpl.newInnerSaveDiffNoCatch]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void nestedInnerSaveDiffNoCatch(User user) {
        //Participating in existing transaction
        userRepository.save(user);
        //Creating nested transaction with name [com.sface.itransaction.service.impl.UserServiceImpl.nestedDivZero]，
        this.userService.nestedDivZero(user);
        //Initiating transaction rollback
        //NestedTransactionNotSupportedException: JpaDialect does not support savepoints - check your JPA provider's capabilities
    }

    //Creating new transaction with name [com.sface.itransaction.service.impl.AccountServiceImpl.nestedInnerSaveSameNoCatch]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void nestedInnerSaveSameNoCatch(User user) {
        //Adding transactional method 'save' with attribute: PROPAGATION_REQUIRED,ISOLATION_DEFAULT， Participating in existing transaction
        userRepository.save(user);
        this.nestedDivZero(user);
        //Initiating transaction rollback
    }
}
