package com.lhd.manager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.lhd.manager.dao.RealTimeInfoMapper;
import com.lhd.manager.dto.NewsAddDTO;
import com.lhd.manager.entity.RealTimeInfo;
import com.lhd.manager.entity.RealTimeInfoExample;
import com.lhd.manager.service.NewsService;
import com.lhd.manager.vo.NewsListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author alan
 * @date 2021/3/29
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private RealTimeInfoMapper infoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addNews(NewsAddDTO newsAddDTO) {
        RealTimeInfo info=new RealTimeInfo();
        BeanUtils.copyProperties(newsAddDTO,info);
        info.setPushTime(new Date());
        byte status=0;
        info.setStatus(status);
        return infoMapper.insertSelective(info)>0;
    }

    @Override
    public Map<String,Object> getNewsList(String title, String author, String type, Byte status, Date startTime, Date endTime) {
        RealTimeInfoExample infoExample=new RealTimeInfoExample();
        RealTimeInfoExample.Criteria criteria=infoExample.createCriteria();
        if(null!=title && !"".equals(title.trim())){
            criteria.andTitleLike("%"+title+"%");
        }
        if(null!=author && !"".equals(author)){
            criteria.andAuthorLike("%"+author+"%");
        }
        if(null!=type && !"".equals(type.trim())){
            criteria.andInfoTypeLike(type);
        }
        if(null!=status){
            criteria.andStatusEqualTo(status);
        }
        if(null!=startTime){
            criteria.andPushTimeGreaterThanOrEqualTo(startTime);
        }
        if(null!=endTime){
            criteria.andPushTimeLessThanOrEqualTo(endTime);
        }
        List<RealTimeInfo> infoList=infoMapper.selectByExample(infoExample);
        PageInfo pageInfo=new PageInfo<>(infoList);
        List<NewsListVO> newsList=new ArrayList<>();
        for(RealTimeInfo info:infoList){
            NewsListVO news=new NewsListVO();
            BeanUtils.copyProperties(info,news);
            if(info.getStatus()==0){
                news.setStatus("未发布");
            }else if(info.getStatus()==1){
                news.setStatus("已发布");
            }else{
                news.setStatus("不再发布");
            }
            newsList.add(news);
        }
        Map<String,Object> map=new HashMap<>(2);
        map.put("pageInfo",pageInfo);
        map.put("list",newsList);
        return map;
    }

    @Override
    public RealTimeInfo getNewsInfo(Long infoId) {
        return infoMapper.selectByPrimaryKey(infoId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeNewsStatus(Long infoId, Byte status) {
        RealTimeInfo info=infoMapper.selectByPrimaryKey(infoId);
        info.setStatus(status);
        return infoMapper.updateByPrimaryKey(info)>0;
    }
}
