package com.lhd.consultation.service.impl;

import com.lhd.consultation.dao.UserMapper;
import com.lhd.consultation.entities.User;
import com.lhd.consultation.service.ChatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChatServiceImpl implements ChatService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean isDoctor(Long userId) {
        String role=userMapper.selectByPrimaryKey(userId).getRole();
        if("DOCTOR".equals(role)){
            return true;
        }
        return false;
    }

    @Override
    public User getUser(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
