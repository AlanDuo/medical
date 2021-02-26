package com.lhd.user.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author alan
 * @date 2021/2/25
 */
@Data
@NoArgsConstructor
public class PrescriptionListVO {
    private Long prescriptionId;

    private String username;

    private String userImg;

    private String hospital;

    private String category;

    private String level;

    private String diagnosisResult;

    private String rp;
}
