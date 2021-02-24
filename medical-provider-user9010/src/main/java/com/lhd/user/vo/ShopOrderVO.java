package com.lhd.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情实体类
 *
 * @author alan
 * @date 2021/2/24
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopOrderVO {
    private Long orderId;

    private Long orderNum;

    private Long goodsId;

    private Long userId;

    private String address;

    private String goodsImg;

    private String goodsName;

    private String goodsDesc;

    private BigDecimal price;

    private String logisticsNum;

    private Byte status;

    private Date createTime;

    private Date payTime;

    private Date deliverTime;

    private Date receiveTime;

    private Date finishTime;
}
