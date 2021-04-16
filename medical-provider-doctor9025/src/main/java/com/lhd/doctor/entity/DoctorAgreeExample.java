package com.lhd.doctor.entity;

import java.util.ArrayList;
import java.util.List;

public class DoctorAgreeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorAgreeExample() {
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

        public Criteria andAgreeIdIsNull() {
            addCriterion("agree_id is null");
            return (Criteria) this;
        }

        public Criteria andAgreeIdIsNotNull() {
            addCriterion("agree_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeIdEqualTo(Long value) {
            addCriterion("agree_id =", value, "agreeId");
            return (Criteria) this;
        }

        public Criteria andAgreeIdNotEqualTo(Long value) {
            addCriterion("agree_id <>", value, "agreeId");
            return (Criteria) this;
        }

        public Criteria andAgreeIdGreaterThan(Long value) {
            addCriterion("agree_id >", value, "agreeId");
            return (Criteria) this;
        }

        public Criteria andAgreeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("agree_id >=", value, "agreeId");
            return (Criteria) this;
        }

        public Criteria andAgreeIdLessThan(Long value) {
            addCriterion("agree_id <", value, "agreeId");
            return (Criteria) this;
        }

        public Criteria andAgreeIdLessThanOrEqualTo(Long value) {
            addCriterion("agree_id <=", value, "agreeId");
            return (Criteria) this;
        }

        public Criteria andAgreeIdIn(List<Long> values) {
            addCriterion("agree_id in", values, "agreeId");
            return (Criteria) this;
        }

        public Criteria andAgreeIdNotIn(List<Long> values) {
            addCriterion("agree_id not in", values, "agreeId");
            return (Criteria) this;
        }

        public Criteria andAgreeIdBetween(Long value1, Long value2) {
            addCriterion("agree_id between", value1, value2, "agreeId");
            return (Criteria) this;
        }

        public Criteria andAgreeIdNotBetween(Long value1, Long value2) {
            addCriterion("agree_id not between", value1, value2, "agreeId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andDcotorIdIsNull() {
            addCriterion("dcotor_id is null");
            return (Criteria) this;
        }

        public Criteria andDcotorIdIsNotNull() {
            addCriterion("dcotor_id is not null");
            return (Criteria) this;
        }

        public Criteria andDcotorIdEqualTo(Long value) {
            addCriterion("dcotor_id =", value, "dcotorId");
            return (Criteria) this;
        }

        public Criteria andDcotorIdNotEqualTo(Long value) {
            addCriterion("dcotor_id <>", value, "dcotorId");
            return (Criteria) this;
        }

        public Criteria andDcotorIdGreaterThan(Long value) {
            addCriterion("dcotor_id >", value, "dcotorId");
            return (Criteria) this;
        }

        public Criteria andDcotorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dcotor_id >=", value, "dcotorId");
            return (Criteria) this;
        }

        public Criteria andDcotorIdLessThan(Long value) {
            addCriterion("dcotor_id <", value, "dcotorId");
            return (Criteria) this;
        }

        public Criteria andDcotorIdLessThanOrEqualTo(Long value) {
            addCriterion("dcotor_id <=", value, "dcotorId");
            return (Criteria) this;
        }

        public Criteria andDcotorIdIn(List<Long> values) {
            addCriterion("dcotor_id in", values, "dcotorId");
            return (Criteria) this;
        }

        public Criteria andDcotorIdNotIn(List<Long> values) {
            addCriterion("dcotor_id not in", values, "dcotorId");
            return (Criteria) this;
        }

        public Criteria andDcotorIdBetween(Long value1, Long value2) {
            addCriterion("dcotor_id between", value1, value2, "dcotorId");
            return (Criteria) this;
        }

        public Criteria andDcotorIdNotBetween(Long value1, Long value2) {
            addCriterion("dcotor_id not between", value1, value2, "dcotorId");
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