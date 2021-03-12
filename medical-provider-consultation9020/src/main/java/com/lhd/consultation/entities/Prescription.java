package com.lhd.consultation.entities;

public class Prescription {
    private Long prescriptionId;

    private Long orderId;

    private Long userId;

    private Long doctorId;

    private String diagnosisResult;

    private String rp;

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDiagnosisResult() {
        return diagnosisResult;
    }

    public void setDiagnosisResult(String diagnosisResult) {
        this.diagnosisResult = diagnosisResult == null ? null : diagnosisResult.trim();
    }

    public String getRp() {
        return rp;
    }

    public void setRp(String rp) {
        this.rp = rp == null ? null : rp.trim();
    }
}