package com.book.usersystem.controller;

import com.book.usersystem.entity.User;
import com.book.usersystem.service.UserService;
import com.book.usersystem.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:Bookman
 * @Date:Created in 15:48 2018/6/20
 */
@Controller
public class EditUserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long userToken) {
        User user = userService.findUserByToken(userToken);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {

        String passwordMD5 = EncryptionUtils.MD5EncodeUtf8(user.getPassword());
        String username = user.getUsername();
        int age = user.getAge();
        long userToken = user.getUserToken();

        userService.updateUserInfo(passwordMD5, age, username, userToken);
        return "redirect:/list";
    }
}
