package com.lhd.doctor.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author alan
 * @date 2021/4/16
 */
@Data
@NoArgsConstructor
public class PrescriptionDTO implements Serializable {
    private Long userId;

    private Long doctorId;

    private String diagnosisResult;

    private String rp;

    private BigDecimal money;
}