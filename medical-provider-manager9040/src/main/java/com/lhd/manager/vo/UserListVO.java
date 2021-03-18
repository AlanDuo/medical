package com.lhd.manager.vo;

import lombok.Data;
import java.util.Date;

/**
 * 用户列表
 *
 * @author alan
 * @date 2021/3/16
 */
@Data
public class UserListVO {
    private Long userId;

    private String username;

    private String phone;

    private Byte gender;

    private Date birthday;
}
