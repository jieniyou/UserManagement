package com.xiaomin.service;

import com.xiaomin.pojo.UserKiss;

import java.util.Collection;

public interface KissService {
    Collection<UserKiss> getAllUserKiss();

    void deleteUserKissById(Integer id);
    void updateUserkiss(UserKiss userKiss);
}
