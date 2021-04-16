package com.lhd.doctor.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author alan
 * @date 2021/4/16
 */
@Data
@NoArgsConstructor
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

    private Byte isAgree;
}
