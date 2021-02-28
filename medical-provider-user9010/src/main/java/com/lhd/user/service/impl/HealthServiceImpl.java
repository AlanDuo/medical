package com.lhd.user.service.impl;

import com.lhd.user.dao.*;
import com.lhd.user.dto.HealthRecordDTO;
import com.lhd.user.entities.*;
import com.lhd.user.service.HealthService;
import com.lhd.user.vo.HealthRecordDetailVO;
import com.lhd.user.vo.HealthRecordListVO;
import com.lhd.user.vo.PrescriptionListVO;
import com.lhd.user.vo.PrescriptionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alan
 * @date 2021/2/25
 */
@Service
public class HealthServiceImpl implements HealthService {
    @Resource
    private PrescriptionMapper prescriptionMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private ConsultationOrderMapper orderMapper;
    @Resource
    private HealthRecordMapper recordMapper;

    @Override
    public List<PrescriptionListVO> getPrescriptionList(Long userId) {
        PrescriptionExample prescriptionExample=new PrescriptionExample();
        PrescriptionExample.Criteria prescriptionCriteria=prescriptionExample.createCriteria();
        prescriptionCriteria.andUserIdEqualTo(userId);
        List<Prescription> prescriptionList=prescriptionMapper.selectByExample(prescriptionExample);
        List<PrescriptionListVO> prescriptionListVOList=new ArrayList<>();
        for(Prescription p:prescriptionList){
            PrescriptionListVO prescriptionListVO=new PrescriptionListVO();
            BeanUtils.copyProperties(p,prescriptionListVO);
            Doctor doctor=doctorMapper.selectByPrimaryKey(p.getDoctorId());
            BeanUtils.copyProperties(doctor,prescriptionListVO);
            User doctorUser=userMapper.selectByPrimaryKey(doctor.getUserId());
            BeanUtils.copyProperties(doctorUser,prescriptionListVO);
            prescriptionListVOList.add(prescriptionListVO);
        }
        return prescriptionListVOList;
    }

    @Override
    public PrescriptionVO getPrescriptionDetail(Long prescriptionId) {
        Prescription prescription=prescriptionMapper.selectByPrimaryKey(prescriptionId);
        if(null!=prescription){
            PrescriptionVO prescriptionVO=new PrescriptionVO();
            BeanUtils.copyProperties(prescription,prescriptionVO);
            ConsultationOrder consultationOrder=orderMapper.selectByPrimaryKey(prescription.getOrderId());
            BeanUtils.copyProperties(consultationOrder,prescriptionVO);
            Doctor doctor=doctorMapper.selectByPrimaryKey(prescription.getDoctorId());
            BeanUtils.copyProperties(doctor,prescriptionVO);
            User userDoctor=userMapper.selectByPrimaryKey(doctor.getUserId());
            prescriptionVO.setDoctorName(userDoctor.getUsername());
            prescriptionVO.setDoctorPhone(userDoctor.getPhone());
            User user=userMapper.selectByPrimaryKey(prescription.getUserId());
            BeanUtils.copyProperties(user,prescriptionVO);

            return prescriptionVO;
        }

        return null;
    }

    @Override
    public List<HealthRecordListVO> getHealthRecordList(Long userId) {
        HealthRecordExample recordExample=new HealthRecordExample();
        recordExample.setOrderByClause("in_time DESC");
        HealthRecordExample.Criteria recordCriteria=recordExample.createCriteria();
        recordCriteria.andUserIdEqualTo(userId);
        List<HealthRecord> recordList=recordMapper.selectByExample(recordExample);
        if(recordList.size()!=0){
            List<HealthRecordListVO> recordListVOList=new ArrayList<>();
            for(HealthRecord record:recordList){
                HealthRecordListVO recordListVO=new HealthRecordListVO();
                BeanUtils.copyProperties(record,recordListVO);
                User user=userMapper.selectByPrimaryKey(record.getUserId());
                recordListVO.setUserName(user.getUsername());
                recordListVOList.add(recordListVO);
            }
            return recordListVOList;
        }
        return null;
    }

    @Override
    public HealthRecordDetailVO getHealthRecordDetail(Long recordId) {
        HealthRecord healthRecord=recordMapper.selectByPrimaryKey(recordId);
        if(null!=healthRecord){
            HealthRecordDetailVO detailVO=new HealthRecordDetailVO();
            BeanUtils.copyProperties(healthRecord,detailVO);
            User user=userMapper.selectByPrimaryKey(healthRecord.getUserId());
            BeanUtils.copyProperties(user,healthRecord);
            return detailVO;
        }
        return null;
    }

    @Override
    public boolean addHealthRecord(HealthRecordDTO recordDTO) {
        HealthRecord record=new HealthRecord();
        BeanUtils.copyProperties(recordDTO,record);

        return recordMapper.insertSelective(record)>0;
    }
}
