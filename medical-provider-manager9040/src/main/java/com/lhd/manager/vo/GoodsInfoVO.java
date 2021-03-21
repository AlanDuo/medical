package com.lhd.manager.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author alan
 * @date 2021/3/20
 */
@Data
public class GoodsInfoVO {
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

    private Date purchaseTime;

    private Date upTime;

    private Date downTime;
}
