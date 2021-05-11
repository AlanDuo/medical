package com.lhd.consultation.service.impl;

import com.lhd.consultation.dao.ConsultationOrderMapper;
import com.lhd.consultation.dao.DoctorMapper;
import com.lhd.consultation.dao.PrescriptionMapper;
import com.lhd.consultation.dao.UserMapper;
import com.lhd.consultation.entities.Doctor;
import com.lhd.consultation.entities.DoctorExample;
import com.lhd.consultation.entities.User;
import com.lhd.consultation.service.ConsultationService;
import com.lhd.consultation.vo.DoctorIntroVO;
import com.lhd.consultation.vo.DoctorListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alan
 * @date 2021/3/2
 */
@Service
public class ConsultationServiceImpl implements ConsultationService {
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private PrescriptionMapper prescriptionMapper;
    @Resource
    private ConsultationOrderMapper orderMapper;

    @Override
    public List<DoctorListVO> getDoctorRecommend(String outpatient) {
        DoctorExample doctorExample=new DoctorExample();
        doctorExample.setOrderByClause("star DESC");
        DoctorExample.Criteria doctorCriteria=doctorExample.createCriteria();
        if(null!=outpatient && !"".equals(outpatient)){
            doctorCriteria.andCategoryLike("%"+outpatient+"%");
        }
        List<Doctor> doctorList=doctorMapper.selectByExample(doctorExample);
        if(doctorList.size()==0){
            return null;
        }
        List<DoctorListVO> doctorListVOList=new ArrayList<>();
        for(Doctor doctor:doctorList){
            DoctorListVO doctorListVO=new DoctorListVO();
            BeanUtils.copyProperties(doctor,doctorListVO);
            User user=userMapper.selectByPrimaryKey(doctor.getUserId());
            BeanUtils.copyProperties(user,doctorListVO);
            doctorListVOList.add(doctorListVO);
        }
        return doctorListVOList;
    }

    @Override
    public DoctorIntroVO getDoctorIntro(Long doctorId) {
        Doctor doctor=doctorMapper.selectByPrimaryKey(doctorId);
        User user=userMapper.selectByPrimaryKey(doctor.getUserId());
        DoctorIntroVO doctorIntroVO=new DoctorIntroVO();
        BeanUtils.copyProperties(doctor,doctorIntroVO);
        BeanUtils.copyProperties(user,doctorIntroVO);
        return doctorIntroVO;
    }
}
