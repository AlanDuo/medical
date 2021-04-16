package com.lhd.doctor.service;

import com.lhd.doctor.dto.PrescriptionDTO;

/**
 * @author alan
 * @date 2021/4/16
 */
public interface ConsultationService {
    boolean addPrescription(PrescriptionDTO prescriptionDTO);
}
