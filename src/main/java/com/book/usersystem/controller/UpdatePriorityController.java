package com.book.usersystem.controller;

import com.book.usersystem.entity.User;
import com.book.usersystem.entity.UserHasRole;
import com.book.usersystem.service.UserHasRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:Bookman
 * @Date:Created in 15:07 2018/6/21
 */
@Controller
public class UpdatePriorityController {

    @Autowired
    private UserHasRoleService userHasRoleService;

    @RequestMapping("/toChangePriority")
    public String toEdit(Model model, @RequestParam long user_token) {
        UserHasRole userRole = userHasRoleService.findUserRoleByUserToken(user_token);

        System.out.println(userRole.getRole_id());
        long userRoleId = userRole.getRole_id();
        long userToken = userRole.getUser_token();

        userHasRoleService.changeUserRole(userRoleId, userToken);
        System.out.println(userRole.getRole_id());

        return "redirect:/listUserPriority";
    }
}
