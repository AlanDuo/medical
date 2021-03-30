package com.lhd.manager.vo;

import lombok.Data;

import java.util.Date;

/**
 * 资讯列表
 *
 * @author alan
 * @date 2021/3/29
 */
@Data
public class NewsListVO {
    private Long infoId;

    private String title;

    private String author;

    private String infoType;

    private Date pushTime;

    private String status;
}
