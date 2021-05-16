package com.lhd.manager.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商城订单列表
 *
 * @author alan
 * @date 2021/3/21
 */
@Data
public class ShopOrderListVO {
    private Long orderId;

    private Long orderNum;

    private Long goodsId;

    private String goodsName;

    private Integer amount;

    private BigDecimal totalPrice;

    private Long userId;

    private String username;

    private String address;

    private String logisticsNum;

    private Byte status;

    private Date createTime;
}
