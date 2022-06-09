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
            return "<center style='" +
                    "font-size:32px;" +
                    "color:green;" +
                    "margin-top: 12%;margin-left:4%;" +
                    "border:5px green solid;" +
                    "width:90%;" +
                    "border-radius:25px;'>添加用户积分成功,点击右上角关闭</center>";
        }catch (Exception e){
            return "<center style='" +
                    "font-size:24px;" +
                    "color:red;" +
                    "margin-top: 12%;margin-left:17%;" +
                    "border:5px red solid;" +
                    "width:67%;" +
                    "border-radius:25px;'>已存在用户的积分或不存在该用户&ensp;请点击右上角关闭</center>";
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
