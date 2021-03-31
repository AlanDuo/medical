package com.lhd.shop.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsInfoVO {
    private Long goodsId;

    private String goodsName;

    private String goodsImg;

    private String introImg;

    private String goodsDesc;

    private String goodsType;

    private String goodsPurpose;

    private String goodsSource;

    private BigDecimal wholesalePrice;

    private Integer stock;

    private Long evaUserId;

    private String evaUsername;

    private String evaUserImg;

    private String evaContent;
}
