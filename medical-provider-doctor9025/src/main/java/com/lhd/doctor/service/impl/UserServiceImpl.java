package com.lhd.doctor.service.impl;

import com.lhd.doctor.dao.ConsultationOrderMapper;
import com.lhd.doctor.dao.DoctorMapper;
import com.lhd.doctor.dao.PrescriptionMapper;
import com.lhd.doctor.dao.UserMapper;
import com.lhd.doctor.dto.MaterialDTO;
import com.lhd.doctor.entity.*;
import com.lhd.doctor.service.UserService;
import com.lhd.doctor.vo.ConsultationVO;
import com.lhd.doctor.vo.MaterialVO;
import com.lhd.doctor.vo.PrescriptionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alan
 * @date 2021/4/17
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private ConsultationOrderMapper consultationOrderMapper;
    @Resource
    private PrescriptionMapper prescriptionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean registerDoctor(MaterialDTO materialDTO) {
        long userId=materialDTO.getUserId();
        User user=userMapper.selectByPrimaryKey(userId);

        Doctor doctor=doctorMapper.selectByUserId(userId);
        if(null==doctor) {
            doctor=new Doctor();
            BeanUtils.copyProperties(materialDTO,doctor);
            doctor.setUsername(user.getUsername());
            doctor.setPhone(user.getPhone());
            byte qualification = 0;
            doctor.setQualifications(qualification);
            doctor.setStar(0);
            return doctorMapper.insertSelective(doctor) > 0;
        } else{
            BeanUtils.copyProperties(materialDTO, doctor);
            doctor.setUsername(user.getUsername());
            doctor.setPhone(user.getPhone());
            byte qualification = 0;
            doctor.setQualifications(qualification);
            doctor.setStar(0);
            return doctorMapper.updateByPrimaryKeySelective(doctor)>0;
        }
    }

    @Override
    public MaterialVO getDoctorMaterial(Long userId) {
        Doctor doctor=doctorMapper.selectByUserId(userId);
        User user=userMapper.selectByPrimaryKey(userId);
        MaterialVO materialVO=new MaterialVO();
        BeanUtils.copyProperties(user,materialVO);
        BeanUtils.copyProperties(doctor,materialVO);
        if(user.getGender()==0){
            materialVO.setGender("女");
        }else{
            materialVO.setGender("男");
        }
        return materialVO;
    }

    @Override
    public List<ConsultationVO> getConsultationRecordList(Long userId) {
        Doctor doctor=doctorMapper.selectByUserId(userId);
        long doctorId=doctor.getDoctorId();
        ConsultationOrderExample orderExample=new ConsultationOrderExample();
        orderExample.setOrderByClause("order_time DESC");
        ConsultationOrderExample.Criteria criteria=orderExample.createCriteria();
        criteria.andDoctorIdEqualTo(doctorId);
        List<ConsultationOrder> orderList=consultationOrderMapper.selectByExample(orderExample);
        List<ConsultationVO> consultationVOList=new ArrayList<>();
        for(ConsultationOrder order:orderList){
            ConsultationVO consultationVO=new ConsultationVO();
            BeanUtils.copyProperties(order,consultationVO);
            Prescription prescription=prescriptionMapper.selectByOrderId(order.getOrderId());
            consultationVO.setDiagnosisResult(prescription.getDiagnosisResult());
            User user=userMapper.selectByPrimaryKey(order.getPatientId());
            consultationVO.setPatientName(user.getUsername());
            consultationVOList.add(consultationVO);
        }
        return consultationVOList;
    }

    @Override
    public PrescriptionVO getPrescriptionDetail(Long orderId) {
        Prescription prescription=prescriptionMapper.selectByOrderId(orderId);
        if(null!=prescription){
            PrescriptionVO prescriptionVO=new PrescriptionVO();
            BeanUtils.copyProperties(prescription,prescriptionVO);
            ConsultationOrder consultationOrder=consultationOrderMapper.selectByPrimaryKey(orderId);
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
}
