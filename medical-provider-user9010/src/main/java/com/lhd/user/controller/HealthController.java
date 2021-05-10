package com.lhd.user.controller;

import com.lhd.user.common.ResponseData;
import com.lhd.user.dto.HealthRecordDTO;
import com.lhd.user.dto.UserDTO;
import com.lhd.user.handler.LoginUserHolder;
import com.lhd.user.service.HealthService;
import com.lhd.user.vo.HealthRecordDetailVO;
import com.lhd.user.vo.HealthRecordListVO;
import com.lhd.user.vo.PrescriptionListVO;
import com.lhd.user.vo.PrescriptionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alan
 * @date 2021/2/24
 */
@RestController
@RequestMapping("/health")
public class HealthController {
    private static final Logger LOGGER=LoggerFactory.getLogger(HealthController.class);
    private HealthService healthService;
    private LoginUserHolder loginUserHolder;
    @Autowired
    public HealthController(HealthService healthService,LoginUserHolder loginUserHolder){
        this.healthService=healthService;
        this.loginUserHolder=loginUserHolder;
    }

    /**
     *=============处方============
     */
    @GetMapping("/prescriptionList")
    public ResponseData prescriptionList(Long userId){
        List<PrescriptionListVO> prescriptionListVOList= healthService.getPrescriptionList(userId);
        return ResponseData.ok().putDataValue(prescriptionListVOList);
    }
    @GetMapping("/prescriptionDetail/{prescriptionId}")
    public ResponseData prescriptionDetail(@PathVariable("prescriptionId")Long prescriptionId){
        PrescriptionVO prescriptionVO=healthService.getPrescriptionDetail(prescriptionId);
        if(null!=prescriptionVO){
            return ResponseData.ok().putDataValue(prescriptionVO);
        }
        return ResponseData.error();
    }
    /**
     *=============健康档案============
     */
    @GetMapping("/healthRecordList")
    public ResponseData healthRecordList(){
        Long userId=loginUserHolder.getCurrentUser().getId();
        List<HealthRecordListVO> recordListVOList=healthService.getHealthRecordList(userId);
        return ResponseData.ok().putDataValue(recordListVOList);
    }
    @GetMapping("/healthRecordDetail/{recordId}")
    public ResponseData healthRecordDetail(@PathVariable("recordId")Long recordId){
        HealthRecordDetailVO detailVO=healthService.getHealthRecordDetail(recordId);
        if(null!=detailVO){
            return ResponseData.ok().putDataValue(detailVO);
        }
        return ResponseData.error();
    }
    @PostMapping("/addHealthRecord")
    public ResponseData addHealthRecord(HealthRecordDTO recordDTO){
        Long userId=loginUserHolder.getCurrentUser().getId();
        recordDTO.setUserId(userId);
        healthService.addHealthRecord(recordDTO);
        return ResponseData.ok();
    }
}
