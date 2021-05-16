package com.lhd.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.manager.common.ResponseData;
import com.lhd.manager.common.TableVO;
import com.lhd.manager.dto.UserDTO;
import com.lhd.manager.entity.Feedback;
import com.lhd.manager.handler.LoginUserHolder;
import com.lhd.manager.service.FeedbackService;
import com.lhd.manager.vo.FeedbackListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/3/18
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private FeedbackService feedbackService;
    private LoginUserHolder loginUserHolder;
    @Autowired
    public FeedbackController(FeedbackService feedbackService,LoginUserHolder loginUserHolder){
        this.feedbackService=feedbackService;
        this.loginUserHolder=loginUserHolder;
    }
    @GetMapping("/feedback_list")
    public TableVO getFeedbackList(String username, String question,Byte status,
                                   @RequestParam(value = "page",defaultValue = "1")Integer page,
                                   @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(page,limit);
        Map<String,Object> map=feedbackService.getFeedbackList(username, question,status);
        PageInfo pageInfo=(PageInfo) map.get("pageInfo");
        List<FeedbackListVO> feedbackListVOList=(List<FeedbackListVO>)map.get("list");
        return new TableVO(pageInfo,feedbackListVOList);
    }
    @GetMapping("/info/{feedbackId}")
    public ResponseData getFeedbackDetail(@PathVariable("feedbackId") Long feedbackId){
        Feedback feedback=feedbackService.getFeedbackDetail(feedbackId);
        return ResponseData.ok().putDataValue(feedback);
    }
    @PostMapping("/feedback_deal")
    public ResponseData dealFeedback(Long feedbackId,String dealDesc){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        System.out.println(feedbackId+" "+userDTO.getUsername()+" "+dealDesc);
        boolean result=feedbackService.dealFeedback(feedbackId, userDTO.getUsername(),dealDesc);
        if(result) {
            return ResponseData.ok();
        }
        return ResponseData.error();
    }
}
