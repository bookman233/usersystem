package com.book.usersystem.controller;

import com.book.usersystem.entity.UserHasRole;
import com.book.usersystem.service.UserHasRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author:Bookman
 * @Date:Created in 14:51 2018/6/20
 */
@Controller
public class ListUserRoleController {

    @Autowired
    private UserHasRoleService userHasRoleService;

    @RequestMapping("/listUserPriority")
    public String findAllUserPriority (Model model) {
        List<UserHasRole> userHasRoles = userHasRoleService.findAllUserHasRole();
        model.addAttribute("userRoles",userHasRoles);
        return "user/userPriorityList";
    }
}
