package com.lhd.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsListVO {
    private Long goodsId;

    private String goodsName;

    private String goodsImg;

    private String goodsDesc;

    private BigDecimal purchasePrice;
}
