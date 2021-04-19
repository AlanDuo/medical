package com.lhd.doctor.controller;

import com.lhd.doctor.common.ResponseData;
import com.lhd.doctor.dto.MaterialDTO;
import com.lhd.doctor.dto.UserDTO;
import com.lhd.doctor.handler.LoginUserHolder;
import com.lhd.doctor.service.UserService;
import com.lhd.doctor.vo.ConsultationVO;
import com.lhd.doctor.vo.MaterialVO;
import com.lhd.doctor.vo.PrescriptionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alan
 * @date 2021/4/17
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private LoginUserHolder loginUserHolder;
    @Autowired
    public UserController(UserService userService,LoginUserHolder loginUserHolder){
        this.userService=userService;
        this.loginUserHolder=loginUserHolder;
    }

    @GetMapping("/info")
    public ResponseData getDoctorInfo(){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        return ResponseData.ok().putDataValue(userDTO);
    }
    @PostMapping("/doctor_apply")
    public ResponseData applyDoctorQualification(MaterialDTO materialDTO){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        materialDTO.setUserId(userDTO.getId());
        userService.registerDoctor(materialDTO);
        return ResponseData.ok();
    }
    @GetMapping("/doctor_material")
    public ResponseData getDoctorMaterial(){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        MaterialVO materialVO=userService.getDoctorMaterial(userDTO.getId());
        return ResponseData.ok().putDataValue(materialVO);
    }
    @GetMapping("/consultation_record")
    public ResponseData getConsultationRecord(){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        List<ConsultationVO> consultationVOList=userService.getConsultationRecordList(userDTO.getId());
        return ResponseData.ok().putDataValue(consultationVOList);
    }
    @GetMapping("/prescription_detail/{orderId}")
    public ResponseData getPrescriptionDetail(@PathVariable("orderId") Long orderId){
        PrescriptionVO prescriptionVO=userService.getPrescriptionDetail(orderId);
        return ResponseData.ok().putDataValue(prescriptionVO);
    }
}
