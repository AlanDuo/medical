package com.lhd.shop.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Goods {
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
