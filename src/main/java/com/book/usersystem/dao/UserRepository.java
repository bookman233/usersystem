package com.book.usersystem.dao;

import com.book.usersystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * @Author:Bookman
 * @Date:Created in 14:36 2018/6/18
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername (String username);

    User findByUsernameAndPassword (String username, String password);

    User findById (long id);

    @Transactional
    @Modifying
    @Query("update User u set u.password=:password, u.age=:age, u.username=:newUsername where u.userToken=:userToken")
    void updateUserInfo (@Param("password")String password, @Param("age") int age, @Param("newUsername") String newUsername, @Param("userToken") long userToken);

    User findByUserToken (long userToken);

    /**
     * 在自定义的delete方法中一定要有事务
     * @param userToken
     */
    @Transactional
    void deleteByUserToken (long userToken);
}
