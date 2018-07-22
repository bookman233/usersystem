package com.book.usersystem.service;

import com.book.usersystem.entity.User;

import java.util.List;

/**
 * @Author:Bookman
 * @Date:Created in 14:39 2018/6/18
 */
public interface UserService {

    List<User> findAllUser ();

    User addUser (User user);

    long findUserIdByUsername (String username);

    User userLogin (String username, String password);

    void updateUserInfo (String password, int age, String newUsername, long userToken);

    User findUserByToken (long userToken);

    void deleteUserByUserToken (long userToken);
}
