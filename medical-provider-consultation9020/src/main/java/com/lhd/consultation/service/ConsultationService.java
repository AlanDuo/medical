package com.lhd.consultation.service;

import com.lhd.consultation.vo.DoctorIntroVO;
import com.lhd.consultation.vo.DoctorListVO;

import java.util.List;

/**
 * @author alan
 * @date 2021/3/2
 */
public interface ConsultationService {
    List<DoctorListVO> getDoctorRecommend(String outpatient);
    DoctorIntroVO getDoctorIntro(Long doctorId);
}
