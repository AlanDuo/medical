package com.lhd.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 健康档案列表VO
 *
 * @author alan
 * @date 2021/2/26
 */
@Data
@NoArgsConstructor
public class HealthRecordListVO {
    private Long recordId;

    private String userName;

    private String relationship;

    private String diagnosisName;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date inTime;

}
