package com.lhd.manager.service;

import com.lhd.manager.vo.DoctorMaterialVO;
import java.util.Map;

/**
 * @author alan
 * @date 2021/3/17
 */
public interface DoctorService {
    Map<String,Object> getDoctorList(String doctorName, String phone, String hospital, String category, Byte qualification);
    DoctorMaterialVO getDoctorMaterial(Long id);
    boolean updateDoctorQualification(Long doctorId,Byte qualification);
}
