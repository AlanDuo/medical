package com.lhd.consultation.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author alan
 * @date 2021/3/2
 */
@Data
@NoArgsConstructor
public class DoctorListVO {
    private Long doctorId;

    private String userImg;

    private String username;

    private String hospital;

    private String category;

    private String level;

    private Integer star;
}
