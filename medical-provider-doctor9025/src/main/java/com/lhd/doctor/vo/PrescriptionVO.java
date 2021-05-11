package com.lhd.doctor.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 处方实体类
 *
 * @author alan
 * @date 2021/2/25
 */
@Data
@NoArgsConstructor
public class PrescriptionVO {
    private Long prescriptionId;

    private String username;

    private Byte gender;

    private Integer age;

    private String doctorName;

    private String doctorPhone;

    private String hospital;

    private String hospitalAddress;

    private String category;

    private String level;

    private BigDecimal money;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date orderTime;

    private String diagnosisResult;

    private String rp;
}
