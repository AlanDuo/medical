package com.lhd.manager.service;

import com.lhd.manager.entity.Feedback;
import com.lhd.manager.vo.FeedbackListVO;

import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/3/18
 */
public interface FeedbackService {
    Map<String,Object> getFeedbackList(String username, String question, Byte status);
    Feedback getFeedbackDetail(Long feedbackId);
    boolean dealFeedback(Long feedbackId,String handler,String dealDesc);
}
