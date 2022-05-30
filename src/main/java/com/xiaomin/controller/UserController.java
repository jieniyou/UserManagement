package com.xiaomin.controller;

import com.xiaomin.dao.UserDao;
import com.xiaomin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/5/29 14:07
 */
@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/list")
    public String list(Model model){

        Collection<User> users = userDao.getAllUser();
        model.addAttribute("users",users);
        return "X-Admin/member-list";
    }

    @RequestMapping("/user/register")
    public String register(){
        return "registered";
    }
    @RequestMapping("/register")
    public String register(User user){
        System.out.println("===>"+user.toString());
        userDao.addUser(user);
        return "index";
    }
    @RequestMapping("/del")
    public String toDelPage(){
        return "X-Admin/member-del";
    }
    @RequestMapping("/level")
    public String toLevelPage(){
        return "X-Admin/member-level";
    }
    @RequestMapping("/kiss")
    public String toKissPage(){
        return "X-Admin/member-kiss";
    }
    @RequestMapping("/view")
    public String toViewPage(){
        return "X-Admin/member-view";
    }
}
