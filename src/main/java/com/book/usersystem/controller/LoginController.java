package com.book.usersystem.controller;

import com.book.usersystem.constant.WebConst;
import com.book.usersystem.entity.User;
import com.book.usersystem.service.UserHasRoleService;
import com.book.usersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:Bookman
 * @Date:Created in 15:47 2018/6/18
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserHasRoleService userHasRoleService;

    /**
     * 扫描时跳转到映射为list的方法
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login () {
        return "login";
    }

    @RequestMapping("/login")
    public String userLogin (@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        User user = userService.userLogin(username, password);

        boolean userRole = userHasRoleService.checkUserRole(user.getUserToken());
        if (userRole == WebConst.IS_ADMIN) {
            System.out.println("是管理员");
            session.setAttribute("user", user);
            return "redirect:/list";
        }

        session.setAttribute("user", user);
        return "normalUser/message";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "user/list";
    }
}
