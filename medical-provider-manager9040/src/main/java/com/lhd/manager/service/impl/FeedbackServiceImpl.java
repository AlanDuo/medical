package com.lhd.manager.service.impl;

import com.lhd.manager.dao.FeedbackMapper;
import com.lhd.manager.entity.Feedback;
import com.lhd.manager.entity.FeedbackExample;
import com.lhd.manager.service.FeedbackService;
import com.lhd.manager.vo.FeedbackListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author alan
 * @date 2021/3/18
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public List<FeedbackListVO> getFeedbackList(String username, String question) {
        FeedbackExample feedbackExample=new FeedbackExample();
        FeedbackExample.Criteria feedbackCriteria=feedbackExample.createCriteria();
        if(null!=username && !"".equals(username)){
            feedbackCriteria.andUsernameLike("%"+username+"%");
        }
        if(null!=question && !"".equals(question.trim())){
            feedbackCriteria.andContentLike("%"+question+"%");
        }
        List<Feedback> feedbackList=feedbackMapper.selectByExample(feedbackExample);
        List<FeedbackListVO> feedbackListVOList=new ArrayList<>();
        for(Feedback feedback:feedbackList){
            FeedbackListVO feedbackListVO=new FeedbackListVO();
            BeanUtils.copyProperties(feedback,feedbackListVO);
            feedbackListVOList.add(feedbackListVO);
        }
        return feedbackListVOList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean dealFeedback(Long feedbackId,String handler, String dealDesc) {
        Feedback feedback=feedbackMapper.selectByPrimaryKey(feedbackId);
        feedback.setHandler(handler);
        feedback.setDealDesc(dealDesc);
        feedback.setDealTime(new Date());

        return feedbackMapper.updateByPrimaryKey(feedback)>0;
    }
}
