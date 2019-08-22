package com.sface.itransaction.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @className User
 * @Desc 用户实体类
 * @Author HZ
 * @Date 2019/8/20 21:16
 * @Version 1.0
 */
@JsonIgnoreProperties("hibernateLazyInitializer")
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -6271288212298440900L;
    /**
     * 主键id
     */
    @Id
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "user_name", nullable = false)
    private String userName;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
