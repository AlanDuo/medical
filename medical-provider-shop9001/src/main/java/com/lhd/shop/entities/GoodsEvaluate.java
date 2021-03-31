package com.lhd.shop.entities;

import java.util.Date;

public class GoodsEvaluate {
    private Long evaluateId;

    private Long userId;

    private Long godosId;

    private String content;

    private String img;

    private Date evaluateTime;

    public Long getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGodosId() {
        return godosId;
    }

    public void setGodosId(Long godosId) {
        this.godosId = godosId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Date getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }
}