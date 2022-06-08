package com.xiaomin.controller;

import com.xiaomin.pojo.UserLevel;
import com.xiaomin.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Date;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/6/8 11:34
 */
@Controller
public class UserLevelController {
    @Autowired
    private UserLevelService userLevelService;

    @RequestMapping("/level")
    public String getAllUserLevels(Model model){
        Collection<UserLevel> allUserLevels = userLevelService.getAllUserLevels();
        model.addAttribute("allLevels",allUserLevels);
        allUserLevels.forEach(x-> System.out.println(x));
        return "X-Admin/member-level";
    }
    @RequestMapping("/levelAdd")
    @ResponseBody
    public String levelAdd(UserLevel userLevel){
        try {
            userLevel.setDateModified(new Date());
            userLevelService.addUserLevel(userLevel);
            System.out.println("userLevel===>"+userLevel);
            return userLevel.toString();
        }catch (Exception e){
            return "已存在用户的积分&ensp;请点击右上角关闭";
        }

    }
    @RequestMapping("/levelUpdate")
    @ResponseBody
    public String levelUpdate(UserLevel userLevel){
        userLevel.setDateModified(new Date());
        userLevelService.updateUserLevel(userLevel);
        System.out.println("userLevel===>"+userLevel);
        return userLevel.toString();
    }
    @RequestMapping("/levelDelete")
    @ResponseBody
    public String levelDelete(long id){
        userLevelService.deleteUserLevelById(id);
        System.err.println("id===>"+id);
        return String.valueOf(id);
    }
}
