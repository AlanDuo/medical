package com.lhd.doctor.service;

import com.lhd.doctor.dto.MaterialDTO;
import com.lhd.doctor.vo.ConsultationVO;
import com.lhd.doctor.vo.MaterialVO;
import com.lhd.doctor.vo.PrescriptionVO;

import java.util.List;

/**
 * @author alan
 * @date 2021/4/17
 */
public interface UserService {
    /**
     * 提交医生材料
     *
     * @param materialDTO
     * @return
     */
    boolean registerDoctor(MaterialDTO materialDTO);

    /**
     * 获取医生资料
     *
     * @param userId
     * @return
     */
    MaterialVO getDoctorMaterial(Long userId);

    /**
     * 获取医生的问诊记录
     *
     * @param userId
     * @return
     */
    List<ConsultationVO> getConsultationRecordList(Long userId);

    /**
     * 处方详情
     *
     * @param orderId
     * @return
     */
    PrescriptionVO getPrescriptionDetail(Long orderId);
}
