package com.lhd.user.dao;

import com.lhd.user.entities.ConsultationOrder;
import com.lhd.user.entities.ConsultationOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsultationOrderMapper {
    int countByExample(ConsultationOrderExample example);

    int deleteByExample(ConsultationOrderExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(ConsultationOrder record);

    int insertSelective(ConsultationOrder record);

    List<ConsultationOrder> selectByExample(ConsultationOrderExample example);

    ConsultationOrder selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") ConsultationOrder record, @Param("example") ConsultationOrderExample example);

    int updateByExample(@Param("record") ConsultationOrder record, @Param("example") ConsultationOrderExample example);

    int updateByPrimaryKeySelective(ConsultationOrder record);

    int updateByPrimaryKey(ConsultationOrder record);
}