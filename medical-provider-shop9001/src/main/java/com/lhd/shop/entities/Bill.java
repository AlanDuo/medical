package com.lhd.shop.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {
    private Long billId;

    private Long userId;

    private BigDecimal money;

    private String purpose;

    private Byte intOrOut;

    private Date billTime;

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public Byte getIntOrOut() {
        return intOrOut;
    }

    public void setIntOrOut(Byte intOrOut) {
        this.intOrOut = intOrOut;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }
}