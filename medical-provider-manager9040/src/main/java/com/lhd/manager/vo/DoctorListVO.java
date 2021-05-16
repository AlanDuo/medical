package com.lhd.manager.vo;

import lombok.Data;

/**
 * @author alan
 * @date 2021/3/17
 */
@Data
public class DoctorListVO {
    private Long doctorId;

    private String username;

    private String phone;

    private String idCard;

    private String hospital;

    private String category;

    private String level;

    private String qualifications;

    private Integer star;
}
