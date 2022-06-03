package com.xiaomin.service;

import com.xiaomin.pojo.User;

import java.util.Collection;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/6/2 11:16
 */
public interface UserService {
    List<User> getAllUser();
    User getUserById(Integer id);

    void addUser(User user);
    void deleteUserById(Integer id);

    void updateUser(User user);
    void updateUserStatusById(Integer id,Integer status);
}
