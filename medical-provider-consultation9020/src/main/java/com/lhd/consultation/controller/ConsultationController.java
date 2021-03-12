package com.lhd.consultation.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.consultation.service.ConsultationService;
import com.lhd.consultation.vo.DoctorIntroVO;
import com.lhd.consultation.vo.DoctorListVO;
import com.lhd.user.common.ResponseData;
import com.lhd.user.common.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alan
 * @date 2021/3/1
 */
@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    private ConsultationService consultationService;
    @Autowired
    public ConsultationController(ConsultationService consultationService){
        this.consultationService=consultationService;
    }

    /**
     * 医生推荐列表
     *
     * @param outpatient
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/doctorRecommend")
    public TableVO doctorRecommend(String outpatient,@RequestParam(value = "page",defaultValue = "1") Integer page,
                                   @RequestParam(value = "limit",defaultValue = "20") Integer limit){
        PageHelper.startPage(page,limit);
        List<DoctorListVO> doctorListVOList=consultationService.getDoctorRecommend(outpatient);
        PageInfo pageInfo=new PageInfo<>(doctorListVOList);
        return new TableVO(pageInfo,doctorListVOList);
    }

    /**
     * 医生简介
     *
     * @param doctorId
     * @return
     */
    @GetMapping("/doctorIntro/{doctorId}")
    public ResponseData doctorIntro(@PathVariable("doctorId") Long doctorId){
        DoctorIntroVO doctorIntroVO=consultationService.getDoctorIntro(doctorId);
        return ResponseData.ok().putDataValue(doctorIntroVO);
    }

}
