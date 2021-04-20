package com.lhd.user.service.impl;

import cn.hutool.core.convert.Convert;
import com.lhd.user.dao.FeedbackMapper;
import com.lhd.user.dao.UserMapper;
import com.lhd.user.dto.FeedbackDTO;
import com.lhd.user.dto.UserRegisterDTO;
import com.lhd.user.entities.Feedback;
import com.lhd.user.entities.User;
import com.lhd.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author alan
 * @date 2021/2/23
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public boolean registerUser(UserRegisterDTO userRegisterDTO){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user=new User();
        BeanUtils.copyProperties(userRegisterDTO,user);
        Date birthday=Convert.toDate(userRegisterDTO.getBirthday());
        user.setBirthday(birthday);
        user.setWallet(BigDecimal.ZERO);
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        return userMapper.insertSelective(user)>0;
    }

    @Override
    public User getUserById(Long userId) {
        User user=userMapper.selectByPrimaryKey(userId);
        if(null!=user){
            return user;
        }
        return null;
    }

    @Override
    public boolean addFeedback(FeedbackDTO feedbackDTO) {
        if(null==feedbackDTO || null==feedbackDTO.getUserId() || null==feedbackDTO.getContent() || 0==feedbackDTO.getUserId()) {
            return false;
        }
        Feedback feedback=new Feedback();
        BeanUtils.copyProperties(feedbackDTO,feedback);
        byte status=0;
        feedback.setStatus(status);
        feedback.setAddTime(new Date());
        return feedbackMapper.insertSelective(feedback)>0;
    }
}
