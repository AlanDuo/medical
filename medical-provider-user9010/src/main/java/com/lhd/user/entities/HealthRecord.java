package com.lhd.user.entities;

import java.util.Date;

public class HealthRecord {
    private Long recordId;

    private Long userId;

    private String name;

    private String relationship;

    private String diagnosisName;

    private Date inTime;

    private Date outTime;

    private String prescription;

    private String remarks;

    private String visitHospital;

    private String treatmentDept;

    private String doctor;

    private String phone;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship == null ? null : relationship.trim();
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName == null ? null : diagnosisName.trim();
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription == null ? null : prescription.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getVisitHospital() {
        return visitHospital;
    }

    public void setVisitHospital(String visitHospital) {
        this.visitHospital = visitHospital == null ? null : visitHospital.trim();
    }

    public String getTreatmentDept() {
        return treatmentDept;
    }

    public void setTreatmentDept(String treatmentDept) {
        this.treatmentDept = treatmentDept == null ? null : treatmentDept.trim();
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}