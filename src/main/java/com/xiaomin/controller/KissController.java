package com.xiaomin.controller;


import com.xiaomin.pojo.UserKiss;
import com.xiaomin.service.KissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class KissController {
    @Autowired
    private KissService kissService;//注入Service


    @RequestMapping("/kiss")
    public String toKissPage(Model model){
        Collection<UserKiss> allUserKiss =kissService.getAllUserKiss();
        model.addAttribute("userkisss",allUserKiss);
        allUserKiss.forEach(x-> System.out.println("allUserKiss===>"+x));
        return "X-Admin/member-kiss";
    }
    @RequestMapping("/userkiss/add")
    @ResponseBody
    public String toAdd(UserKiss userKiss){
        try {
            kissService.addUserkiss(userKiss);
            System.out.println(userKiss);
            return "<center style='color:green'>添加成功,点击右上角关闭</center>";
        }catch (Exception e){
            return "<center style='color:red'>添加失败,用户ID已在列表或不存在该用户,点击右上角关闭</center>";
        }

    }
    @RequestMapping("/user/delSelUserKiss")
    public String deleteUserKissById(String kissids){
        System.out.println("进入了批量删除====>"+kissids);
        String[] id=kissids.split(",");
        for (String s : id) {
            int i = Integer.parseInt(s);
            kissService.deleteUserKissById(i);
        }
        return "main";
    }
    @RequestMapping("/userkiss/edit")
    public String toEdit(UserKiss userKiss){
        System.out.println(userKiss);
        kissService.updateUserkiss(userKiss);
        return "X-Admin/member-kiss";
    }
}
