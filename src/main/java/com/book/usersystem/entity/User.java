package com.book.usersystem.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @Author:Bookman
 * @Date:Created in 14:09 2018/6/18
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    private String password;

    private int age;

    private long userToken;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getUserToken() {
        return userToken;
    }

    public void setUserToken(long userToken) {
        this.userToken = userToken;
    }

    public User() {
    }

    public User(String username, String password, int age, long userToken) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.userToken = userToken;
    }
}
