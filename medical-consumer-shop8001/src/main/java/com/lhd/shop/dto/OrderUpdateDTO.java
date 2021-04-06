package com.lhd.shop.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author alan
 * @Date 2021/4/2
 */
@Data
public class OrderUpdateDTO implements Serializable {
    private Long orderNum;

    private String username;

    private String phone;

    private String address;
}
