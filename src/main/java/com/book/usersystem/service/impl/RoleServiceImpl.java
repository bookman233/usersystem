package com.book.usersystem.service.impl;

import com.book.usersystem.entity.Role;
import com.book.usersystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Bookman
 * @Date:Created in 9:22 2018/6/20
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleService roleService;

    @Override
    public List<Role> findAllRole() {
        List<Role> roles = roleService.findAllRole();
        return roles;
    }

    @Override
    public Role findRoleByName(String roleName) {
        return roleService.findRoleByName(roleName);
    }

    @Override
    public void addRole(Role role) {
        roleService.addRole(role);
    }

    @Override
    public void deleteRoleByName(String roleName) {
        roleService.deleteRoleByName(roleName);
    }

    @Override
    public void modifyRole(String oldRoleName, String newRoleName) {
        roleService.modifyRole(oldRoleName, newRoleName);
    }
}
