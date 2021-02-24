package com.lhd.user.dao;

import com.lhd.user.entities.HealthRecord;
import com.lhd.user.entities.HealthRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HealthRecordMapper {
    int countByExample(HealthRecordExample example);

    int deleteByExample(HealthRecordExample example);

    int deleteByPrimaryKey(Long recordId);

    int insert(HealthRecord record);

    int insertSelective(HealthRecord record);

    List<HealthRecord> selectByExample(HealthRecordExample example);

    HealthRecord selectByPrimaryKey(Long recordId);

    int updateByExampleSelective(@Param("record") HealthRecord record, @Param("example") HealthRecordExample example);

    int updateByExample(@Param("record") HealthRecord record, @Param("example") HealthRecordExample example);

    int updateByPrimaryKeySelective(HealthRecord record);

    int updateByPrimaryKey(HealthRecord record);
}