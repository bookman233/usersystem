package com.book.usersystem.controller;

import com.book.usersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:Bookman
 * @Date:Created in 16:35 2018/6/20
 */
@Controller
public class DeleteUserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/delete")
    public String delete(Long userToken) {
        userService.deleteUserByUserToken(userToken);
        return "redirect:/list";
    }
}
