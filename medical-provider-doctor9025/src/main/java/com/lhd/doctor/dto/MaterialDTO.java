package com.lhd.doctor.dto;

import lombok.Data;

/**
 * @author alan
 * @date 2021/4/17
 */
@Data
public class MaterialDTO {
    private Long userId;

    private String username;

    private String phone;

    private String hospital;

    private String category;

    private String level;

    private String material;

    private String intro;

    private String goodAt;
}
