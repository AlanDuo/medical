package com.lhd.user.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HealthRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HealthRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Long value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Long value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Long value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Long value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Long> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Long> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Long value1, Long value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRelationshipIsNull() {
            addCriterion("relationship is null");
            return (Criteria) this;
        }

        public Criteria andRelationshipIsNotNull() {
            addCriterion("relationship is not null");
            return (Criteria) this;
        }

        public Criteria andRelationshipEqualTo(String value) {
            addCriterion("relationship =", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotEqualTo(String value) {
            addCriterion("relationship <>", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipGreaterThan(String value) {
            addCriterion("relationship >", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipGreaterThanOrEqualTo(String value) {
            addCriterion("relationship >=", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLessThan(String value) {
            addCriterion("relationship <", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLessThanOrEqualTo(String value) {
            addCriterion("relationship <=", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLike(String value) {
            addCriterion("relationship like", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotLike(String value) {
            addCriterion("relationship not like", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipIn(List<String> values) {
            addCriterion("relationship in", values, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotIn(List<String> values) {
            addCriterion("relationship not in", values, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipBetween(String value1, String value2) {
            addCriterion("relationship between", value1, value2, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotBetween(String value1, String value2) {
            addCriterion("relationship not between", value1, value2, "relationship");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameIsNull() {
            addCriterion("diagnosis_name is null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameIsNotNull() {
            addCriterion("diagnosis_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameEqualTo(String value) {
            addCriterion("diagnosis_name =", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameNotEqualTo(String value) {
            addCriterion("diagnosis_name <>", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameGreaterThan(String value) {
            addCriterion("diagnosis_name >", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameGreaterThanOrEqualTo(String value) {
            addCriterion("diagnosis_name >=", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameLessThan(String value) {
            addCriterion("diagnosis_name <", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameLessThanOrEqualTo(String value) {
            addCriterion("diagnosis_name <=", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameLike(String value) {
            addCriterion("diagnosis_name like", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameNotLike(String value) {
            addCriterion("diagnosis_name not like", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameIn(List<String> values) {
            addCriterion("diagnosis_name in", values, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameNotIn(List<String> values) {
            addCriterion("diagnosis_name not in", values, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameBetween(String value1, String value2) {
            addCriterion("diagnosis_name between", value1, value2, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameNotBetween(String value1, String value2) {
            addCriterion("diagnosis_name not between", value1, value2, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(Date value) {
            addCriterionForJDBCDate("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(Date value) {
            addCriterionForJDBCDate("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(List<Date> values) {
            addCriterionForJDBCDate("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(Date value) {
            addCriterionForJDBCDate("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(Date value) {
            addCriterionForJDBCDate("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(List<Date> values) {
            addCriterionForJDBCDate("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIsNull() {
            addCriterion("prescription is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIsNotNull() {
            addCriterion("prescription is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEqualTo(String value) {
            addCriterion("prescription =", value, "prescription");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNotEqualTo(String value) {
            addCriterion("prescription <>", value, "prescription");
            return (Criteria) this;
        }

        public Criteria andPrescriptionGreaterThan(String value) {
            addCriterion("prescription >", value, "prescription");
            return (Criteria) this;
        }

        public Criteria andPrescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("prescription >=", value, "prescription");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLessThan(String value) {
            addCriterion("prescription <", value, "prescription");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLessThanOrEqualTo(String value) {
            addCriterion("prescription <=", value, "prescription");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLike(String value) {
            addCriterion("prescription like", value, "prescription");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNotLike(String value) {
            addCriterion("prescription not like", value, "prescription");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIn(List<String> values) {
            addCriterion("prescription in", values, "prescription");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNotIn(List<String> values) {
            addCriterion("prescription not in", values, "prescription");
            return (Criteria) this;
        }

        public Criteria andPrescriptionBetween(String value1, String value2) {
            addCriterion("prescription between", value1, value2, "prescription");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNotBetween(String value1, String value2) {
            addCriterion("prescription not between", value1, value2, "prescription");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalIsNull() {
            addCriterion("visit_hospital is null");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalIsNotNull() {
            addCriterion("visit_hospital is not null");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalEqualTo(String value) {
            addCriterion("visit_hospital =", value, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalNotEqualTo(String value) {
            addCriterion("visit_hospital <>", value, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalGreaterThan(String value) {
            addCriterion("visit_hospital >", value, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalGreaterThanOrEqualTo(String value) {
            addCriterion("visit_hospital >=", value, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalLessThan(String value) {
            addCriterion("visit_hospital <", value, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalLessThanOrEqualTo(String value) {
            addCriterion("visit_hospital <=", value, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalLike(String value) {
            addCriterion("visit_hospital like", value, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalNotLike(String value) {
            addCriterion("visit_hospital not like", value, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalIn(List<String> values) {
            addCriterion("visit_hospital in", values, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalNotIn(List<String> values) {
            addCriterion("visit_hospital not in", values, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalBetween(String value1, String value2) {
            addCriterion("visit_hospital between", value1, value2, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andVisitHospitalNotBetween(String value1, String value2) {
            addCriterion("visit_hospital not between", value1, value2, "visitHospital");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptIsNull() {
            addCriterion("treatment_dept is null");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptIsNotNull() {
            addCriterion("treatment_dept is not null");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptEqualTo(String value) {
            addCriterion("treatment_dept =", value, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptNotEqualTo(String value) {
            addCriterion("treatment_dept <>", value, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptGreaterThan(String value) {
            addCriterion("treatment_dept >", value, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptGreaterThanOrEqualTo(String value) {
            addCriterion("treatment_dept >=", value, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptLessThan(String value) {
            addCriterion("treatment_dept <", value, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptLessThanOrEqualTo(String value) {
            addCriterion("treatment_dept <=", value, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptLike(String value) {
            addCriterion("treatment_dept like", value, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptNotLike(String value) {
            addCriterion("treatment_dept not like", value, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptIn(List<String> values) {
            addCriterion("treatment_dept in", values, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptNotIn(List<String> values) {
            addCriterion("treatment_dept not in", values, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptBetween(String value1, String value2) {
            addCriterion("treatment_dept between", value1, value2, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andTreatmentDeptNotBetween(String value1, String value2) {
            addCriterion("treatment_dept not between", value1, value2, "treatmentDept");
            return (Criteria) this;
        }

        public Criteria andDoctorIsNull() {
            addCriterion("doctor is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIsNotNull() {
            addCriterion("doctor is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorEqualTo(String value) {
            addCriterion("doctor =", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotEqualTo(String value) {
            addCriterion("doctor <>", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorGreaterThan(String value) {
            addCriterion("doctor >", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorGreaterThanOrEqualTo(String value) {
            addCriterion("doctor >=", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorLessThan(String value) {
            addCriterion("doctor <", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorLessThanOrEqualTo(String value) {
            addCriterion("doctor <=", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorLike(String value) {
            addCriterion("doctor like", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotLike(String value) {
            addCriterion("doctor not like", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorIn(List<String> values) {
            addCriterion("doctor in", values, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotIn(List<String> values) {
            addCriterion("doctor not in", values, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorBetween(String value1, String value2) {
            addCriterion("doctor between", value1, value2, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotBetween(String value1, String value2) {
            addCriterion("doctor not between", value1, value2, "doctor");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}