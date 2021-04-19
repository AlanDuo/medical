package com.lhd.doctor.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author alan
 * @date 2021/4/17
 */
@Data
@NoArgsConstructor
public class ConsultationVO {
    private Long orderId;
    private Long patientId;
    private String patientName;
    private Date orderTime;
    private String diagnosisResult;
}
