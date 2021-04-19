package com.lhd.doctor.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lhd.doctor.dao.ConsultationOrderMapper;
import com.lhd.doctor.dao.PrescriptionMapper;
import com.lhd.doctor.dto.PrescriptionDTO;
import com.lhd.doctor.entity.ConsultationOrder;
import com.lhd.doctor.entity.Prescription;
import com.lhd.doctor.service.ConsultationService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

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
        ConsultationOrder consultationOrder=new ConsultationOrder();
        String numbers= RandomUtil.randomString("123456789",6);
        long orderId=Long.parseLong(numbers);
        consultationOrder.setOrderId(orderId);
        consultationOrder.setPatientId(prescriptionDTO.getUserId());
        consultationOrder.setDoctorId(prescriptionDTO.getDoctorId());
        consultationOrder.setMoney(prescriptionDTO.getMoney());
        consultationOrder.setOrderTime(new Date());
        orderMapper.insert(consultationOrder);
        Prescription prescription=new Prescription();
        BeanUtils.copyProperties(prescriptionDTO,prescription);
        prescription.setOrderId(orderId);
        return prescriptionMapper.insertSelective(prescription)>0;
    }
}
