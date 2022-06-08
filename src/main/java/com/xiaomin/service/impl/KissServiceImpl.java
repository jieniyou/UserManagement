package com.xiaomin.service.impl;

import com.xiaomin.mapper.KissMapper;
import com.xiaomin.pojo.UserKiss;
import com.xiaomin.service.KissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class KissServiceImpl implements KissService {
    @Autowired
    private KissMapper kissMapper;
    @Override
    public Collection<UserKiss> getAllUserKiss() {
        return kissMapper.getAllUserkiss();
    }

    @Override
    public void deleteUserKissById(Integer id) {
        kissMapper.deleteUserKissById(id);
    }

    @Override
    public void updateUserkiss(UserKiss userKiss) {
        kissMapper.updateUserkiss(userKiss);
    }
}
