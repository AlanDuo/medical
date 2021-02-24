package com.lhd.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 商城订单列表实体类
 *
 * @author alan
 * @date 2021/2/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopOrderListVO {
    private Long orderId;

    private Long goodsId;

    private String goodsImg;

    private String goodsName;

    private String goodsDesc;

    private BigDecimal price;

    private Byte status;
}
