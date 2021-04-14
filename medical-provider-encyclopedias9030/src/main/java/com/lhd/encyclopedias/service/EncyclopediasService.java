package com.lhd.encyclopedias.service;

import com.lhd.encyclopedias.vo.NewsDetailVO;

import java.util.Map;

/**
 * @author alan
 * @date 2021/4/9
 */
public interface EncyclopediasService {
    Map<String,Object> searchNewsList(String type);
    NewsDetailVO getNewsDetail(Long infoId);
}
