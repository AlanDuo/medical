package com.lhd.user.service;

import com.lhd.user.entities.Bill;
import com.lhd.user.entities.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author alan
 * @date 2021/2/23
 */
public interface UserService {
    User getUserById(Long userId);
}
