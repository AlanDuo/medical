package com.lhd.user.service;

import com.lhd.user.vo.HealthRecordDetailVO;
import com.lhd.user.vo.HealthRecordListVO;
import com.lhd.user.vo.PrescriptionListVO;
import com.lhd.user.vo.PrescriptionVO;

import java.util.List;

/**
 * @author alan
 * @date 2021/2/25
 */
public interface HealthService {
    List<PrescriptionListVO> getPrescriptionList(Long userId);
    PrescriptionVO getPrescriptionDetail(Long prescriptionId);
    List<HealthRecordListVO> getHealthRecordList(Long userId);
    HealthRecordDetailVO getHealthRecordDetail(Long recordId);
}
