package com.lhd.doctor.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author alan
 * @date 2021/4/17
 */
@Data
public class MaterialVO {
    private Long doctorId;

    private Long userId;

    private String idCard;

    private String gender;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;

    private String username;

    private String phone;

    private String hospital;

    private String category;

    private String level;

    private String material;

    private String intro;

    private Byte qualifications;

    private Integer star;

    private String goodAt;
}
