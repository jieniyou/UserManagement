package com.xiaomin.controller;

import com.xiaomin.dao.UserDao;
import com.xiaomin.mapper.UserMapper;
import com.xiaomin.pojo.User;
import com.xiaomin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;//注入Service

    /**
     * 测试
     * @return
     */
    @GetMapping("/AllUserList")
    @ResponseBody
    public Collection<User> getAllUser() {
        System.out.println("进入User列表");
        Collection<User> allUser = userService.getAllUser();
        allUser.forEach(x-> System.out.println(x));
        return allUser;
    }

    @RequestMapping("/list")
    public String list(Model model){
        Collection<User> users = userService.getAllUser();
        model.addAttribute("users",users);
        return "X-Admin/member-list";
    }
    @RequestMapping("/vip-list")
    public String vipList(Model model){
        Collection<User> users = userService.getAllUser();
        model.addAttribute("users",users);
        return "X-Admin/member-vip-list";
    }

    @RequestMapping("/user/register")
    public String ToRegisterPage(){
        System.out.println("进入注册页面");
        return "registered";
    }
    @RequestMapping("/register")
    public String ToRegister(User user){
        System.out.println("===>"+user.toString());
        userService.addUser(user);
        return "redirect:/index.html";
    }

    @RequestMapping("/user/add")
    public String toAdd(User user){
        userService.addUser(user);
        return "main";
    }
    @RequestMapping("/user/edit")
    public String toEdit(User user){
        System.out.println(user);
        userService.updateUser(user);
        return "main";
    }
    @RequestMapping("/user/del")
    public String toDel(Integer id){
        System.out.println("执行删除方法,删除===>"+id);
        userService.deleteUserById(id);
        return "main";
    }
    @RequestMapping("/user/delSelector")
    public String toDelSelector(String ids){
        System.out.println("进入了批量删除====>"+ids);
        String[] id=ids.split(",");
        for (String s : id) {
            int i = Integer.parseInt(s);
            userService.deleteUserById(i);
        }
        return "main";
    }

    @RequestMapping("/user/getUserById")
    public String toGetUserById(Integer username,Model model){
        User user = userService.getUserById(username);
        System.out.println("============>"+username);
        model.addAttribute("getUserById",user);
        return "main";
    }

    @RequestMapping("/level")
    public String toLevelPage(){
        return "X-Admin/member-level";
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
