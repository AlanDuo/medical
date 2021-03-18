package com.lhd.manager.service;

import com.lhd.manager.vo.DoctorListVO;
import com.lhd.manager.vo.DoctorMaterialVO;

import java.util.List;

/**
 * @author alan
 * @date 2021/3/17
 */
public interface DoctorService {
    List<DoctorListVO> getDoctorList(String doctorName,String phone,String hospital,String category,Byte qualification);
    DoctorMaterialVO getDoctorMaterial(Long id);
    boolean updateDoctorQualification(Long doctorId,Byte qualification);
}
