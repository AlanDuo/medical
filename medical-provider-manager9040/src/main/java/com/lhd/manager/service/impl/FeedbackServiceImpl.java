package com.lhd.manager.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhd.manager.dao.FeedbackMapper;
import com.lhd.manager.entity.Feedback;
import com.lhd.manager.entity.FeedbackExample;
import com.lhd.manager.service.FeedbackService;
import com.lhd.manager.vo.FeedbackListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author alan
 * @date 2021/3/18
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public Map<String,Object> getFeedbackList(String username, String question, Byte status) {
        FeedbackExample feedbackExample=new FeedbackExample();
        FeedbackExample.Criteria feedbackCriteria=feedbackExample.createCriteria();
        if(null!=username && !"".equals(username)){
            feedbackCriteria.andUsernameLike("%"+username+"%");
        }
        if(null!=question && !"".equals(question.trim())){
            feedbackCriteria.andContentLike("%"+question+"%");
        }
        feedbackCriteria.andStatusEqualTo(status);
        List<Feedback> feedbackList=feedbackMapper.selectByExample(feedbackExample);
        Map<String, Object> map=new HashMap<>(2);
        PageInfo pageInfo=new PageInfo<>(feedbackList);

        List<FeedbackListVO> feedbackListVOList=new ArrayList<>();
        for(Feedback feedback:feedbackList){
            FeedbackListVO feedbackListVO=new FeedbackListVO();
            BeanUtils.copyProperties(feedback,feedbackListVO);
            feedbackListVOList.add(feedbackListVO);
        }
        map.put("pageInfo",pageInfo);
        map.put("list",feedbackListVOList);
        return map;
    }

    @Override
    public Feedback getFeedbackDetail(Long feedbackId) {
        return feedbackMapper.selectByPrimaryKey(feedbackId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean dealFeedback(Long feedbackId,String handler, String dealDesc) {
        Feedback feedback=feedbackMapper.selectByPrimaryKey(feedbackId);
        feedback.setHandler(handler);
        feedback.setDealDesc(dealDesc);
        byte status=1;
        feedback.setStatus(status);
        feedback.setDealTime(new Date());

        return feedbackMapper.updateByPrimaryKey(feedback)>0;
    }
}
