package com.xiaomin.mapper;

import com.xiaomin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/6/2 11:08
 */
@Mapper
@Repository
public interface UserMapper {

    List<User> getAllUser();
    User getUserById(Integer id);

    void addUser(User user);
    void deleteUserById(Integer id);

    void updateUser(User user);
    void updateUserStatusById(Integer id,Integer status);

}
