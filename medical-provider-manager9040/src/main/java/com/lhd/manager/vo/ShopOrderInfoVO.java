package com.lhd.manager.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情
 *
 * @author alan
 * @date 2021/3/21
 */
@Data
public class ShopOrderInfoVO {
    private Long orderId;

    private Long orderNum;

    private Long goodsId;

    private String goodsName;

    private String goodsImg;

    private String goodsDesc;

    private String goodsType;

    private String goodsPurpose;

    private String goodsSource;

    private BigDecimal wholesalePrice;

    private Long userId;

    private String username;

    private String phone;

    private String address;

    private String logisticsNum;

    private Byte status;

    private Date createTime;

    private Date payTime;

    private Date deliverTime;

    private Date receiveTime;

    private Date finishTime;
}
