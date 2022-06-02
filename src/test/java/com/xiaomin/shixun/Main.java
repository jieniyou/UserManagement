package com.xiaomin.shixun;

import com.xiaomin.controller.UserController;
import org.junit.jupiter.api.Test;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/6/2 13:54
 */
public class Main {
    @Test
    public void getAllUser(){
        UserController userController=new UserController();
        Collection allUser = userController.getAllUser();
        System.out.println(allUser.toArray());
    }
}
