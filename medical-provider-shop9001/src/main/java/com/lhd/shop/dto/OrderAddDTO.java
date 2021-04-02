package com.lhd.shop.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 下单
 * @author alan
 * @date 2021/4/1
 */
@Data
public class OrderAddDTO implements Serializable {

    private Long orderNum;

    private Long goodsId;

    private String goodsName;

    private Long userId;

    private String username;

    private String phone;

    private String address;

}
