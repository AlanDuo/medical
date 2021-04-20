package com.lhd.auth.service;

import com.lhd.auth.dao.UserDao;
import com.lhd.auth.domain.UserRegisterDTO;
import com.lhd.auth.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Resource
    private UserDao userDao;

    public boolean registerUser(UserRegisterDTO userRegisterDTO){
        User user=new User();
        BeanUtils.copyProperties(userRegisterDTO,user);
        user.setWallet(BigDecimal.ZERO);
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        return userDao.registerUser(user)>0;
    }
}
