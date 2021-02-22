package com.lhd.auth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private String username;
    private String phone;
    private String password;
    private String userImg;
    private String idCard;
    private Byte gender;
    private Date birthday;
    private BigDecimal wallet;
    private String role;
}
