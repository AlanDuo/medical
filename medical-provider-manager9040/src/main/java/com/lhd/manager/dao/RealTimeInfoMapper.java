package com.lhd.manager.dao;

import com.lhd.manager.entity.RealTimeInfo;
import com.lhd.manager.entity.RealTimeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RealTimeInfoMapper {
    int countByExample(RealTimeInfoExample example);

    int deleteByExample(RealTimeInfoExample example);

    int deleteByPrimaryKey(Long infoId);

    int insert(RealTimeInfo record);

    int insertSelective(RealTimeInfo record);

    List<RealTimeInfo> selectByExampleWithBLOBs(RealTimeInfoExample example);

    List<RealTimeInfo> selectByExample(RealTimeInfoExample example);

    RealTimeInfo selectByPrimaryKey(Long infoId);

    int updateByExampleSelective(@Param("record") RealTimeInfo record, @Param("example") RealTimeInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") RealTimeInfo record, @Param("example") RealTimeInfoExample example);

    int updateByExample(@Param("record") RealTimeInfo record, @Param("example") RealTimeInfoExample example);

    int updateByPrimaryKeySelective(RealTimeInfo record);

    int updateByPrimaryKeyWithBLOBs(RealTimeInfo record);

    int updateByPrimaryKey(RealTimeInfo record);
}