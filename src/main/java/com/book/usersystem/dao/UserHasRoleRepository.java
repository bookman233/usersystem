package com.book.usersystem.dao;

import com.book.usersystem.entity.UserHasRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * @Author:Bookman
 * @Date:Created in 15:01 2018/6/18
 */
public interface UserHasRoleRepository extends JpaRepository<UserHasRole, String> {

    /**
     * 检查用户权限的方法
     * @param user_token
     * @return
     */
    @Transactional
    @Query("select u from UserHasRole u where u.user_token=:user_token")
    UserHasRole findUserRoleByUserToken (@Param("user_token") long user_token);

    @Modifying
    @Transactional
    @Query("update UserHasRole u set u.role_id=:role_id where u.user_token=:user_token")
    void updateUserRole (@Param("role_id")long role_id, @Param("user_token") long user_token);

//    @Modifying
//    UserHasRole findByUser_token (long userToken);
}
