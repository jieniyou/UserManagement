package com.xiaomin.service;

import com.xiaomin.pojo.UserLevel;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/6/8 10:51
 */
public interface UserLevelService {
    Collection<UserLevel> getAllUserLevels();
    UserLevel getUserLevelById(Integer id);
    void addUserLevel(UserLevel userLevel);
    void updateUserLevel(UserLevel userLevel);
    void deleteUserLevelById(long id);
}
