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
