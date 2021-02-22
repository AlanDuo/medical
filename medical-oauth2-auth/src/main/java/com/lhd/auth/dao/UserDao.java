package com.lhd.auth.dao;

import com.lhd.auth.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    User selectUserByPhone(@Param("phone") String phone);
}
