package com.xiaomin.service.impl;

import com.xiaomin.mapper.UserMapper;
import com.xiaomin.pojo.User;
import com.xiaomin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/6/2 11:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Collection<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
    @Override
    public User login(String userName,String password){
        return userMapper.login(userName,password);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void updateUserStatusById(Integer id,Integer status) {
        userMapper.updateUserStatusById(id,status);
    }
}
