package com.lhd.user.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 健康档案详情
 *
 * @author alan
 * @date 2021/2/26
 */
@Data
@NoArgsConstructor
public class HealthRecordDetailVO {
    private Long recordId;

    private String username;

    private String userImg;

    private Byte gender;

    private Integer age;

    private String relationship;

    private String diagnosisName;

    private Date inTime;

    private Date outTime;

    private String prescription;

    private String remarks;

    private String visitHospital;

    private String treatmentDept;

    private String doctor;

    private String phone;
}
