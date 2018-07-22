package com.book.usersystem.service.impl;

import com.book.usersystem.dao.UserRepository;
import com.book.usersystem.entity.User;
import com.book.usersystem.service.UserService;
import com.book.usersystem.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Bookman
 * @Date:Created in 9:02 2018/6/20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 返回所有的用户信息
     * @return users
     */
    @Override
    public List<User> findAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }

    /**
     * 添加用户
     * @param user
     * @return user
     */
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    /**
     * 通过用户名查询用户ID
     * @param username
     * @return userId
     */
    @Override
    public long findUserIdByUsername(String username) {
        User user = userRepository.findByUsername(username);
        long userId = user.getId();
        return userId;
    }

    @Override
    public User userLogin(String username, String password) {
        if (username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
            System.out.println("用户名或是密码不能为空");
        }

        String passwordMD5 = EncryptionUtils.MD5EncodeUtf8(password);

        User user = userRepository.findByUsernameAndPassword(username, passwordMD5);
        return user;
    }

    @Override
    public void updateUserInfo(String password, int age, String newUsername, long userToken) {
        userRepository.updateUserInfo(password, age, newUsername, userToken);
    }

    @Override
    public User findUserByToken(long userToken) {
        return userRepository.findByUserToken(userToken);
    }

    @Override
    public void deleteUserByUserToken(long userToken) {
        userRepository.deleteByUserToken(userToken);
    }
}
