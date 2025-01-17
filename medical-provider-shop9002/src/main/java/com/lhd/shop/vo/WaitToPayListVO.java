package com.lhd.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 等待支付列表
 *
 * @author alan
 * @date 2021/4/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaitToPayListVO implements Serializable {
    private  Long orderId;

    private Long userId;

    private Long goodsId;

    private String goodsName;

    private String goodsImg;

    private String goodsDesc;

    private BigDecimal wholesalePrice;

    private Integer amount;
}
