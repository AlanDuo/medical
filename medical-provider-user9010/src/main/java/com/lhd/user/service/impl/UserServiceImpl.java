package com.lhd.user.service.impl;

import com.lhd.user.dao.UserMapper;
import com.lhd.user.entities.User;
import com.lhd.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author alan
 * @date 2021/2/23
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(Long userId) {
        User user=userMapper.selectByPrimaryKey(userId);
        if(null!=user){
            return user;
        }
        return null;
    }
}
