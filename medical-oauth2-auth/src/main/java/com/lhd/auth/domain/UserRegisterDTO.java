package com.lhd.auth.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户注册
 * @author alan
 * @date 2021/4/15
 */
@Data
@NoArgsConstructor
public class UserRegisterDTO implements Serializable {
    private String username;
    private String phone;
    private String password;
    private String userImg;
    private String idCard;
    private Byte gender;
    private Date birthday;
    private String role;
}
