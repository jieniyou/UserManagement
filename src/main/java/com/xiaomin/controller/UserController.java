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
    @RequestMapping("/vip-list")
    public String vipList(Model model){

        Collection<User> users = userDao.getAllUser();
        model.addAttribute("users",users);
        return "X-Admin/member-vip-list";
    }

    @RequestMapping("/user/register")
    public String ToRegisterPage(){
        return "registered";
    }
    @RequestMapping("/register")
    public String ToRegister(User user){
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
    @RequestMapping("/echarts1")
    public String toEcharts1Page(){
        return "X-Admin/echarts1";
    }
    @RequestMapping("/echarts2")
    public String toEcharts2Page(){
        return "X-Admin/echarts2";
    }
    @RequestMapping("/echarts3")
    public String toEcharts3Page(){
        return "X-Admin/echarts3";
    }
    @RequestMapping("/echarts4")
    public String toEcharts4Page(){
        return "X-Admin/echarts4";
    }
    @RequestMapping("/echarts5")
    public String toEcharts5Page(){
        return "X-Admin/echarts5";
    }
    @RequestMapping("/echarts6")
    public String toEcharts6Page(){
        return "X-Admin/echarts6";
    }
    @RequestMapping("/demo")
    public String toDemoPage(){
        return "X-Admin/demo";
    }
}
