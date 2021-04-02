package com.lhd.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 购物车
 *
 * @author alan
 * @date 2020/2/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopCartVO implements Serializable {


    private Long userId;

    private Long goodsId;

    private String goodsName;

    private String goodsImg;

    private String goodsDesc;

    private BigDecimal purchasePrice;

    private Integer amount;
}
