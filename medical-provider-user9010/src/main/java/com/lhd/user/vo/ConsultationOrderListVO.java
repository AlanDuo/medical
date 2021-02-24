package com.lhd.user.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author alan
 * @date 2021/2/24
 */
@Data
@NoArgsConstructor
public class ConsultationOrderListVO {
    private Long orderId;

    private Long doctorId;

    private Long userId;

    private String hospital;

    private String category;

    private String level;

    private String diagnosisResult;

    private String username;

    private String userImg;

    private BigDecimal money;

    private Date orderTime;
}
