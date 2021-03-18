package com.lhd.manager.service;

import com.lhd.manager.vo.FeedbackListVO;

import java.util.List;

/**
 * @author alan
 * @date 2021/3/18
 */
public interface FeedbackService {
    List<FeedbackListVO> getFeedbackList(String username,String question);
    boolean dealFeedback(Long feedbackId,String handler,String dealDesc);
}
