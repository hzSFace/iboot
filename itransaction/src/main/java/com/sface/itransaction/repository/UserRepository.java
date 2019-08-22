package com.sface.itransaction.repository;

import com.sface.itransaction.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @className UserRepository
 * @Desc TODO (这里用一句话描述这个类的作用)
 * @Author HZ
 * @Date 2019/8/20 21:41
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
