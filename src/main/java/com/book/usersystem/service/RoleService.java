package com.book.usersystem.service;

import com.book.usersystem.entity.Role;

import java.util.List;

/**
 * @Author:Bookman
 * @Date:Created in 14:39 2018/6/18
 */
public interface RoleService {

    List<Role> findAllRole ();

    Role findRoleByName (String roleName);

    void addRole (Role role);

    void deleteRoleByName (String roleName);

    void modifyRole(String oldRoleName, String newRoleName);
}
