package com.book.usersystem.service;

import com.book.usersystem.entity.UserHasRole;

import java.util.List;

/**
 * @Author:Bookman
 * @Date:Created in 10:32 2018/6/20
 */
public interface UserHasRoleService {

    void addUserRole (UserHasRole userHasRole);

    boolean checkUserRole (long userToken);

    void changeUserRole (long userRoleId, long userToken);

    UserHasRole findUserRoleByUserToken (long userToken);

    List<UserHasRole> findAllUserHasRole ();
}
