package com.lhd.manager.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author alan
 * @date 2021/3/20
 */
@Data
public class GoodsAddDTO implements Serializable {

    private String goodsName;

    private String goodsImg;

    private String goodsDesc;

    private String goodsType;

    private String goodsPurpose;

    private String goodsSource;

    private String introImg;

    private BigDecimal purchasePrice;

    private BigDecimal wholesalePrice;

    private Integer stock;
}
