package com.lhd.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.manager.common.ResponseData;
import com.lhd.manager.common.TableVO;
import com.lhd.manager.service.FeedbackService;
import com.lhd.manager.vo.FeedbackListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alan
 * @date 2021/3/18
 */
@RestController
@RequestMapping("/manager/feedback")
public class FeedbackController {
    private FeedbackService feedbackService;
    @Autowired
    public FeedbackController(FeedbackService feedbackService){
        this.feedbackService=feedbackService;
    }
    @GetMapping("/feedback_list")
    public TableVO getFeedbackList(String username, String question,
                                        @RequestParam(value = "page",defaultValue = "1")Integer page,
                                        @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(page,limit);
        List<FeedbackListVO> feedbackListVOList=feedbackService.getFeedbackList(username, question);
        PageInfo pageInfo=new PageInfo<>(feedbackListVOList);

        return new TableVO(pageInfo,feedbackListVOList);
    }
    @PutMapping("/feedback_deal")
    public ResponseData dealFeedback(Long feedbackId,String handler,String dealDesc){
        boolean result=feedbackService.dealFeedback(feedbackId, handler, dealDesc);
        if(result) {
            return ResponseData.ok();
        }
        return ResponseData.error();
    }
}
