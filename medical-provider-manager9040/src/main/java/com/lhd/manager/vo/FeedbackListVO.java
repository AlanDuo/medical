package com.lhd.manager.vo;

import lombok.Data;

import java.util.Date;

/**
 * 反馈列表
 *
 * @author alan
 * @date 2021/3/18
 */
@Data
public class FeedbackListVO {
    private Long feedbackId;

    private String username;

    private String content;

    private String contact;

    private String picture;

    private Byte status;

    private String handler;

    private String dealDesc;

    private Date addTime;

    private Date dealTime;
}
