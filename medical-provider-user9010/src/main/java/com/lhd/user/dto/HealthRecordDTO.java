package com.lhd.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author alan
 * @date 2021/2/27
 */
@Data
@NoArgsConstructor
public class HealthRecordDTO {
    private Long recordId;

    private Long userId;

    private String name;

    private String relationship;

    private String diagnosisName;

    private String inTime;

    private String outTime;

    private String prescription;

    private String remarks;

    private String visitHospital;

    private String treatmentDept;

    private String doctor;

    private String phone;
}
