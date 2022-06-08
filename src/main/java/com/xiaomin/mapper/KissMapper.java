package com.xiaomin.mapper;

import com.xiaomin.pojo.UserKiss;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface KissMapper {
     Collection<UserKiss> getAllUserkiss() ;

    void deleteUserKissById(Integer id);
    void updateUserkiss(UserKiss userKiss);
}
