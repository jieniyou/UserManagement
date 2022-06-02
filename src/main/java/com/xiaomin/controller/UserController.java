package com.xiaomin.controller;

import com.xiaomin.dao.UserDao;
import com.xiaomin.pojo.User;
import com.xiaomin.service.UserService;
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
    UserService userService;

    public Collection getAllUser(){
        Collection<User> allUser = userService.getAllUser();
        return allUser;
    }

    public static void main(String[] args) {
        UserController u=new UserController();
        Collection allUser = u.getAllUser();
        System.out.println(allUser.toArray());
    }



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

    @RequestMapping("/user/add")
    public String toAdd(User user){
        userDao.addUser(user);
        return "main";
    }
    @RequestMapping("/user/edit")
    public String toEdit(User user){
        userDao.addUser(user);
        return "main";
    }
    @RequestMapping("/user/del")
    public String toDel(Integer id){
        System.out.println("执行删除方法,删除===>"+id);
        userDao.deleteUserById(id);
        return "main";
    }
    @RequestMapping("/user/getUserById")
    public String toGetUserById(Integer username,Model model){
        User user = userDao.getUserById(username);
        System.out.println("============>"+username);
        model.addAttribute("getUserById",user);
        return "main";
    }




    @RequestMapping("/level")
    public String toLevelPage(){
        return "X-Admin/member-level";
    }
    @RequestMapping("/kiss")
    public String toKissPage(){
        return "X-Admin/member-kiss";
    }

    /**
     * echarts图表
     * @return
     */
    @RequestMapping("/echarts1")
    public String toEcharts1Page(){
        return "X-Admin/echarts1";
    }
    @RequestMapping("/echarts2")
    public String toEcharts2Page(){
        return "X-Admin/echarts2";
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
