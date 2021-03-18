package com.lhd.manager.service.impl;

import com.lhd.manager.dao.DoctorMapper;
import com.lhd.manager.entity.Doctor;
import com.lhd.manager.entity.DoctorExample;
import com.lhd.manager.service.DoctorService;
import com.lhd.manager.vo.DoctorListVO;
import com.lhd.manager.vo.DoctorMaterialVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alan
 * @date 2021/3/17
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public List<DoctorListVO> getDoctorList(String doctorName, String phone, String hospital, String category,Byte qualification) {
        DoctorExample doctorExample=new DoctorExample();
        DoctorExample.Criteria doctorCriteria=doctorExample.createCriteria();
        if(null!=doctorName && !"".equals(doctorName.trim())){
            doctorCriteria.andUsernameLike("%"+doctorName+"%");
        }
        if(null!=phone && !"".equals(phone.trim())){
            doctorCriteria.andPhoneEqualTo(phone);
        }
        if(null!=hospital && !"".equals(hospital.trim())){
            doctorCriteria.andHospitalLike("%"+hospital+"%");
        }
        if(null!=category && !"".equals(category.trim())){
            doctorCriteria.andCategoryLike("%"+category+"%");
        }
        if(null!=qualification){
            doctorCriteria.andQualificationsEqualTo(qualification);
        }
        List<Doctor> doctorList=doctorMapper.selectByExample(doctorExample);
        List<DoctorListVO> doctorListVOList=new ArrayList<>();
        for(Doctor doctor:doctorList){
            DoctorListVO doctorListVO=new DoctorListVO();
            BeanUtils.copyProperties(doctor,doctorListVO);
            doctorListVOList.add(doctorListVO);
        }

        return doctorListVOList;
    }

    @Override
    public DoctorMaterialVO getDoctorMaterial(Long id) {
        Doctor doctor=doctorMapper.selectByPrimaryKey(id);
        if(null!=doctor){
            DoctorMaterialVO doctorMaterialVO=new DoctorMaterialVO();
            BeanUtils.copyProperties(doctor,doctorMaterialVO);
            return doctorMaterialVO;
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateDoctorQualification(Long doctorId, Byte qualification) {
        Doctor doctor=doctorMapper.selectByPrimaryKey(doctorId);
        doctor.setQualifications(qualification);
        return doctorMapper.insertSelective(doctor)>0;
    }

}
