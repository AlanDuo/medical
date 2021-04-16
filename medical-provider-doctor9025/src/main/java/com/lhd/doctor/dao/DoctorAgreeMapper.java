package com.lhd.doctor.dao;

import com.lhd.doctor.entity.DoctorAgree;
import com.lhd.doctor.entity.DoctorAgreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorAgreeMapper {
    int countByExample(DoctorAgreeExample example);

    int deleteByExample(DoctorAgreeExample example);

    int deleteByPrimaryKey(Long agreeId);

    int insert(DoctorAgree record);

    int insertSelective(DoctorAgree record);

    List<DoctorAgree> selectByExample(DoctorAgreeExample example);

    DoctorAgree selectByPrimaryKey(Long agreeId);

    DoctorAgree selectByGoodsIdAndDoctorId(@Param("goodsId") Long goodsId,@Param("doctorId") Long doctorId);

    int updateByExampleSelective(@Param("record") DoctorAgree record, @Param("example") DoctorAgreeExample example);

    int updateByExample(@Param("record") DoctorAgree record, @Param("example") DoctorAgreeExample example);

    int updateByPrimaryKeySelective(DoctorAgree record);

    int updateByPrimaryKey(DoctorAgree record);
}