package com.lhd.shop.dao;

import com.lhd.shop.entities.GoodsEvaluate;
import com.lhd.shop.entities.GoodsEvaluateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsEvaluateMapper {
    int countByExample(GoodsEvaluateExample example);

    int deleteByExample(GoodsEvaluateExample example);

    int deleteByPrimaryKey(Long evaluateId);

    int insert(GoodsEvaluate record);

    int insertSelective(GoodsEvaluate record);

    List<GoodsEvaluate> selectByExample(GoodsEvaluateExample example);

    GoodsEvaluate selectByPrimaryKey(Long evaluateId);

    int updateByExampleSelective(@Param("record") GoodsEvaluate record, @Param("example") GoodsEvaluateExample example);

    int updateByExample(@Param("record") GoodsEvaluate record, @Param("example") GoodsEvaluateExample example);

    int updateByPrimaryKeySelective(GoodsEvaluate record);

    int updateByPrimaryKey(GoodsEvaluate record);
}