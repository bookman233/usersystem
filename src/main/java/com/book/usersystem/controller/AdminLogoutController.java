package com.book.usersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author:Bookman
 * @Date:Created in 10:42 2018/6/21
 */
@Controller
public class AdminLogoutController {

    @RequestMapping("/logout")
    public String userLogout (HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
