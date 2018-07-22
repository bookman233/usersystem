package com.book.usersystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author:Bookman
 * @Date:Created in 9:52 2018/6/20
 */
@Entity
public class UserHasRole {

    @Id
    private long user_token;
    private long role_id;

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public long getUser_token() {
        return user_token;
    }

    public void setUser_token(long user_token) {
        this.user_token = user_token;
    }

    public UserHasRole(long user_token, long role_id) {
        this.user_token = user_token;
        this.role_id = role_id;
    }

    public UserHasRole() {
    }
}
