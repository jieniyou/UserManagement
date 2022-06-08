package com.xiaomin.mapper;

import com.xiaomin.pojo.UserLevel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/6/8 10:47
 */
@Mapper
@Repository
public interface UserLevelMapper {
    Collection<UserLevel> getAllUserLevels();
    UserLevel getUserLevelById(Integer id);
    void addUserLevel(UserLevel userLevel);
    void updateUserLevel(UserLevel userLevel);
    void deleteUserLevelById(long id);
}
