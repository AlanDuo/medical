package com.lhd.encyclopedias.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhd.encyclopedias.dao.RealTimeInfoMapper;
import com.lhd.encyclopedias.entity.RealTimeInfo;
import com.lhd.encyclopedias.entity.RealTimeInfoExample;
import com.lhd.encyclopedias.service.EncyclopediasService;
import com.lhd.encyclopedias.vo.NewsDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/4/9
 */
@Service
public class EncyclopediasServiceImpl implements EncyclopediasService {
    @Resource
    private RealTimeInfoMapper infoMapper;

    @Override
    public Map<String, Object> searchNewsList(String type) {
        RealTimeInfoExample infoExample=new RealTimeInfoExample();
        infoExample.setOrderByClause("DESC push_time");
        RealTimeInfoExample.Criteria criteria=infoExample.createCriteria();
        if(null!=type && !"".equals(type.trim())){
            criteria.andInfoTypeLike("%"+type+"%");
        }
        byte status=1;
        criteria.andStatusEqualTo(status);
        List<RealTimeInfo> newsList=infoMapper.selectByExample(infoExample);
        PageInfo pageInfo=new PageInfo<>(newsList);
        Map<String, Object> map=new HashMap<>(2);
        map.put("pageInfo",pageInfo);
        map.put("list",newsList);
        return map;
    }

    @Override
    public NewsDetailVO getNewsDetail(Long infoId) {
        RealTimeInfo news=infoMapper.selectByPrimaryKey(infoId);
        NewsDetailVO detailVO=new NewsDetailVO();
        BeanUtils.copyProperties(news,detailVO);
        return detailVO;
    }
}
