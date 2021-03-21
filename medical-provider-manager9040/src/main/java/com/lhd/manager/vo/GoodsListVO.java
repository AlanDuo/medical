package com.lhd.manager.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品列表
 *
 * @author alan
 * @date 2021/3/19
 */
@Data
public class GoodsListVO {
    private Long goodsId;

    private String goodsName;

    private String goodsImg;

    private String goodsDesc;

    private String goodsType;

    private String goodsPurpose;

    private String goodsSource;

    private BigDecimal purchasePrice;

    private BigDecimal wholesalePrice;

    private Integer stock;

    private Byte status;
}
