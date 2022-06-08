package com.xiaomin.controller;


import com.xiaomin.pojo.UserKiss;
import com.xiaomin.service.KissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
