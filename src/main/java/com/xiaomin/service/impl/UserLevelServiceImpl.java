package com.xiaomin.service.impl;

import com.xiaomin.mapper.UserLevelMapper;
import com.xiaomin.pojo.UserLevel;
import com.xiaomin.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/6/8 10:54
 */
@Service
public class UserLevelServiceImpl implements UserLevelService {
    @Autowired
    private UserLevelMapper userLevelMapper;
    @Override
    public Collection<UserLevel> getAllUserLevels() {
        return userLevelMapper.getAllUserLevels();
    }

    @Override
    public UserLevel getUserLevelById(Integer id) {
        return userLevelMapper.getUserLevelById(id);
    }

    @Override
    public void addUserLevel(UserLevel userLevel) {
        userLevelMapper.addUserLevel(userLevel);
    }

    @Override
    public void updateUserLevel(UserLevel userLevel) {
        userLevelMapper.updateUserLevel(userLevel);
    }

    @Override
    public void deleteUserLevelById(long id) {
        userLevelMapper.deleteUserLevelById(id);
    }
}
