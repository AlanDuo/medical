package com.lhd.doctor.controller;

import com.lhd.doctor.common.ResponseData;
import com.lhd.doctor.dto.PrescriptionDTO;
import com.lhd.doctor.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alan
 * @date 2021/4/16
 */
@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    private ConsultationService consultationService;
    @Autowired
    public ConsultationController(ConsultationService consultationService){
        this.consultationService=consultationService;
    }

    @PostMapping("/addPrescription")
    public ResponseData addPrescription(PrescriptionDTO prescriptionDTO){
        consultationService.addPrescription(prescriptionDTO);
        return ResponseData.ok();
    }
}
