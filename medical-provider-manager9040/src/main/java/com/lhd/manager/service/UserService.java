package com.lhd.manager.service;

import com.lhd.manager.entity.User;
import com.lhd.manager.vo.UserListVO;

import java.util.List;

/**
 * @author alan
 * @date 2021/3/16
 */
public interface UserService {
    List<UserListVO> getUserList(String phone,String username);
    User getUserById(Long userId);
}
