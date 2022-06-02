package com.xiaomin.mapper;

import com.xiaomin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/6/2 11:08
 */
@Mapper
public interface UserMapper {

    Collection<User> getAllUser();
    User getUserById(Integer id);

    void addUser(User user);
    void deleteUserById(Integer id);

    void updateUser(User user);
    void updateUserStatusById(Integer id,Integer status);

}
