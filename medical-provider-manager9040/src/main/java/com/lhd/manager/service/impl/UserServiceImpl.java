package com.lhd.manager.service.impl;

import com.lhd.manager.dao.UserMapper;
import com.lhd.manager.entity.User;
import com.lhd.manager.entity.UserExample;
import com.lhd.manager.service.UserService;
import com.lhd.manager.vo.UserListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alan
 * @date 2021/3/16
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserListVO> getUserList(String phone, String username) {
        UserExample userExample=new UserExample();
        UserExample.Criteria userCriteria=userExample.createCriteria();
        if(null!=phone && !"".equals(phone.trim())) {
            userCriteria.andPhoneEqualTo(phone);
        }
        if(null!=username && !"".equals(username.trim())){
            userCriteria.andUsernameLike("%"+username+"%");
        }
        List<User> userList=userMapper.selectByExample(userExample);
        List<UserListVO> userListVOList=new ArrayList<>();
        for(User user:userList){
            UserListVO userListVO=new UserListVO();
            BeanUtils.copyProperties(user,userListVO);
            userListVOList.add(userListVO);
        }
        return userListVOList;
    }
}
