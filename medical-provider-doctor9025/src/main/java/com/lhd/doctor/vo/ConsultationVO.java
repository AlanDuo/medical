package com.lhd.doctor.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date orderTime;
    private String diagnosisResult;
}
