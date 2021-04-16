package com.lhd.doctor.service.impl;

import com.lhd.doctor.dao.ConsultationOrderMapper;
import com.lhd.doctor.dao.PrescriptionMapper;
import com.lhd.doctor.dto.PrescriptionDTO;
import com.lhd.doctor.service.ConsultationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author alan
 * @date 2021/4/16
 */
@Service
public class ConsultationServiceImpl implements ConsultationService {
    @Resource
    private ConsultationOrderMapper orderMapper;
    @Resource
    private PrescriptionMapper prescriptionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addPrescription(PrescriptionDTO prescriptionDTO) {
        //先产生咨询订单，再添加处方

        return false;
    }
}
