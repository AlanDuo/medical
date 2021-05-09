package com.lhd.shop.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Long goodsId;

    private String goodsName;

    private String goodsImg;

    private String introImg;

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

    private Integer weight;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public String getIntroImg() {
        return introImg;
    }

    public void setIntroImg(String introImg) {
        this.introImg = introImg == null ? null : introImg.trim();
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public String getGoodsPurpose() {
        return goodsPurpose;
    }

    public void setGoodsPurpose(String goodsPurpose) {
        this.goodsPurpose = goodsPurpose == null ? null : goodsPurpose.trim();
    }

    public String getGoodsSource() {
        return goodsSource;
    }

    public void setGoodsSource(String goodsSource) {
        this.goodsSource = goodsSource == null ? null : goodsSource.trim();
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}