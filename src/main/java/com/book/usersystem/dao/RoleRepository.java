package com.book.usersystem.dao;

import com.book.usersystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * @Author:Bookman
 * @Date:Created in 14:38 2018/6/18
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * 更新用户权限表的信息
     * @param roleOldName
     * @param roleNewName
     */
    @Transactional
    @Modifying
    @Query("update Role r set r.roleName=:roleNewName where r.roleName=:roleOldName")
    void updateRoleInfo (@Param("roleOldName")String roleOldName, @Param("roleNewName")String roleNewName);
}
