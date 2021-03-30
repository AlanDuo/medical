package com.lhd.manager.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 资讯增加
 *
 * @author alan
 * @date 2021/3/29
 */
@Data
public class NewsAddDTO implements Serializable {
    private String title;

    private String author;

    private String infoType;

    private String infoContent;
}
