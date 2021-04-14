package com.lhd.encyclopedias.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author alan
 * @date 2021/4/9
 */
@Data
public class NewsDetailVO {
    private Long infoId;

    private String title;

    private String author;

    private String infoType;

    private Date pushTime;

    private String infoContent;
}
