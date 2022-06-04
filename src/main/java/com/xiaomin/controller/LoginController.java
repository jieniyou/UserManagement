package com.xiaomin.controller;

import com.xiaomin.dao.UserDao;
import com.xiaomin.pojo.User;
import com.xiaomin.service.UserService;
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

    @Autowired
    private UserService userService;

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password,
            Model model, HttpSession session){

        User userLogin = userService.login(userName, password);
        if (userName.equals("XiaoMin") &&
                password.equals("1314520")){
            session.setAttribute("loginUser",userName);
            return "redirect:/main.html";
        }else if (userLogin!=null && userLogin.getIdentity()==1 && userLogin.getStatus()==1){
            session.setAttribute("loginUser",userName);
            return "redirect:/main.html";
        }else if (userLogin!=null && userLogin.getIdentity()==0){
            model.addAttribute("msg","您的权限不够,请使用管理员账户登录");
            return "index";
        }else if (userLogin!=null && userLogin.getIdentity()==1 && userLogin.getStatus()==0){
            model.addAttribute("msg","您的账号已停用,请联系XiaoMin大BOSS修改");
            return "index";
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
