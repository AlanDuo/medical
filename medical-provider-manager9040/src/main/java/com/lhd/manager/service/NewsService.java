package com.lhd.manager.service;

import com.lhd.manager.dto.NewsAddDTO;
import com.lhd.manager.entity.RealTimeInfo;
import com.lhd.manager.vo.NewsListVO;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/3/29
 */
public interface NewsService {
    boolean addNews(NewsAddDTO newsAddDTO);
    Map<String,Object> getNewsList(String title, String author, String type, Byte status, Date startTime, Date endTime);
    RealTimeInfo getNewsInfo(Long infoId);
    boolean changeNewsStatus(Long infoId,Byte status);
}
