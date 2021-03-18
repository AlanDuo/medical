package com.lhd.manager.vo;

import lombok.Data;

/**
 * 医生资料
 *
 * @author alan
 * @date 2021/3/18
 */
@Data
public class DoctorMaterialVO {
    private Long doctorId;

    private String username;

    private String phone;

    private String hospital;

    private String category;

    private String level;

    private String material;

    private String intro;

    private Byte qualifications;

    private Integer star;
}
