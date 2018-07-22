package com.book.usersystem.controller;

import com.book.usersystem.constant.WebConst;
import com.book.usersystem.entity.User;
import com.book.usersystem.entity.UserHasRole;
import com.book.usersystem.service.UserHasRoleService;
import com.book.usersystem.service.UserService;
import com.book.usersystem.utils.CommonUtils;
import com.book.usersystem.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:Bookman
 * @Date:Created in 15:31 2018/6/18
 */
@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    UserHasRoleService userHasRoleService;

    @RequestMapping("/toRegister")
    public String toRegister() {
        System.out.println("跳转到添加界面");
        return "user/register";
    }

    @RequestMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam int age) {

        long userToken = (long)(CommonUtils.makeRandomInt());
        String userPassword = (EncryptionUtils.MD5EncodeUtf8(password));
        User user = new User(username, userPassword, age ,userToken);

        userService.addUser(user);

        UserHasRole userHasRole = new UserHasRole(userToken, WebConst.USER_ROLE_NORMAL);
        userHasRoleService.addUserRole(userHasRole);
        System.out.println("success");

        return "redirect:/login";
    }

}
