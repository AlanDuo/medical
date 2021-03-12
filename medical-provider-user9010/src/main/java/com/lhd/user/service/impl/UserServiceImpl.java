package com.lhd.user.service.impl;

import com.lhd.user.dao.FeedbackMapper;
import com.lhd.user.dao.UserMapper;
import com.lhd.user.dto.FeedbackDTO;
import com.lhd.user.entities.Feedback;
import com.lhd.user.entities.User;
import com.lhd.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
