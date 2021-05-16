package com.lhd.manager.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author alan
 * @date 2021/3/21
 */
@Data
public class ShopOrderUpdateDTO {
    private Long orderId;

    private String username;

    private String phone;

    private String address;

    private String logisticsNum;

    private Byte operate;
}
