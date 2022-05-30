package com.xiaomin.controller;

import com.xiaomin.dao.UserDao;
import com.xiaomin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/5/28 11:23
 */
@Controller
public class LoginController {

    //@Autowired
    //private UserDao userDao;

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password,
            Model model, HttpSession session){
        if (userName.equals("XiaoMin") &&
            password.equals("1314520")){
            session.setAttribute("loginUser",userName);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
