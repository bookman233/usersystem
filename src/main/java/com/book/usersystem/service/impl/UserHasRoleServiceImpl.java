package com.book.usersystem.service.impl;

import com.book.usersystem.constant.WebConst;
import com.book.usersystem.dao.UserHasRoleRepository;
import com.book.usersystem.entity.UserHasRole;
import com.book.usersystem.service.UserHasRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Bookman
 * @Date:Created in 10:33 2018/6/20
 */
@Service
public class UserHasRoleServiceImpl implements UserHasRoleService {

    @Autowired
    UserHasRoleRepository userRoleRepository;

    /**
     * 添加用户与权限的对应关系
     * @param userHasRole
     */
    @Override
    public void addUserRole(UserHasRole userHasRole) {
        userRoleRepository.save(userHasRole);
    }

    @Override
    public boolean checkUserRole(long userToken) {
        UserHasRole userHasRole = userRoleRepository.findUserRoleByUserToken(userToken);
        if (userHasRole.getRole_id() == WebConst.USER_ROLE_ADMIN) {
            return true;
        }

        return false;
    }

    /**
     * 更改用户的权限
     * @param userRoleId
     * @param userToken
     */
    @Override
    public void changeUserRole(long userRoleId, long userToken) {

        long newUserRole;

        if (userRoleId == WebConst.USER_ROLE_ADMIN) {
            newUserRole = WebConst.USER_ROLE_NORMAL;
            userRoleRepository.updateUserRole(newUserRole, userToken);
        }
        if (userRoleId == WebConst.USER_ROLE_NORMAL) {
            newUserRole = WebConst.USER_ROLE_ADMIN;
            userRoleRepository.updateUserRole(newUserRole, userToken);
        }
    }

    /**
     * 根据用户的userToken找到对应用户的权限
     * @param userToken
     * @return
     */
    @Override
    public UserHasRole findUserRoleByUserToken(long userToken) {
        return userRoleRepository.findUserRoleByUserToken(userToken);
    }

    /**
     * 返回所有的用户与权限关系
     * @return
     */
    @Override
    public List<UserHasRole> findAllUserHasRole() {
        List<UserHasRole> userHasRoles = userRoleRepository.findAll();
        return userHasRoles;
    }


}
