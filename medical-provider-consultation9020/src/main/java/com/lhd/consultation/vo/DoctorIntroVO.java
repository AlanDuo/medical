package com.lhd.consultation.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author alan
 * @date 2021/3/2
 */
@Data
@NoArgsConstructor
public class DoctorIntroVO {
    private Long doctorId;

    private String username;

    private String userImg;

    private String hospital;

    private String category;

    private String level;

    private String material;

    private String intro;

    private Integer star;
}
