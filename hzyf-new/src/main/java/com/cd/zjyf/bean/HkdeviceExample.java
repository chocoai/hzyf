package com.cd.zjyf.bean;

import java.util.ArrayList;
import java.util.List;

public class HkdeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HkdeviceExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andYljgidIsNull() {
            addCriterion("YLJGID is null");
            return (Criteria) this;
        }

        public Criteria andYljgidIsNotNull() {
            addCriterion("YLJGID is not null");
            return (Criteria) this;
        }

        public Criteria andYljgidEqualTo(String value) {
            addCriterion("YLJGID =", value, "yljgid");
            return (Criteria) this;
        }

        public Criteria andYljgidNotEqualTo(String value) {
            addCriterion("YLJGID <>", value, "yljgid");
            return (Criteria) this;
        }

        public Criteria andYljgidGreaterThan(String value) {
            addCriterion("YLJGID >", value, "yljgid");
            return (Criteria) this;
        }

        public Criteria andYljgidGreaterThanOrEqualTo(String value) {
            addCriterion("YLJGID >=", value, "yljgid");
            return (Criteria) this;
        }

        public Criteria andYljgidLessThan(String value) {
            addCriterion("YLJGID <", value, "yljgid");
            return (Criteria) this;
        }

        public Criteria andYljgidLessThanOrEqualTo(String value) {
            addCriterion("YLJGID <=", value, "yljgid");
            return (Criteria) this;
        }

        public Criteria andYljgidLike(String value) {
            addCriterion("YLJGID like", value, "yljgid");
            return (Criteria) this;
        }

        public Criteria andYljgidNotLike(String value) {
            addCriterion("YLJGID not like", value, "yljgid");
            return (Criteria) this;
        }

        public Criteria andYljgidIn(List<String> values) {
            addCriterion("YLJGID in", values, "yljgid");
            return (Criteria) this;
        }

        public Criteria andYljgidNotIn(List<String> values) {
            addCriterion("YLJGID not in", values, "yljgid");
            return (Criteria) this;
        }

        public Criteria andYljgidBetween(String value1, String value2) {
            addCriterion("YLJGID between", value1, value2, "yljgid");
            return (Criteria) this;
        }

        public Criteria andYljgidNotBetween(String value1, String value2) {
            addCriterion("YLJGID not between", value1, value2, "yljgid");
            return (Criteria) this;
        }

        public Criteria andIndexcodeIsNull() {
            addCriterion("INDEXCODE is null");
            return (Criteria) this;
        }

        public Criteria andIndexcodeIsNotNull() {
            addCriterion("INDEXCODE is not null");
            return (Criteria) this;
        }

        public Criteria andIndexcodeEqualTo(String value) {
            addCriterion("INDEXCODE =", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeNotEqualTo(String value) {
            addCriterion("INDEXCODE <>", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeGreaterThan(String value) {
            addCriterion("INDEXCODE >", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeGreaterThanOrEqualTo(String value) {
            addCriterion("INDEXCODE >=", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeLessThan(String value) {
            addCriterion("INDEXCODE <", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeLessThanOrEqualTo(String value) {
            addCriterion("INDEXCODE <=", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeLike(String value) {
            addCriterion("INDEXCODE like", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeNotLike(String value) {
            addCriterion("INDEXCODE not like", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeIn(List<String> values) {
            addCriterion("INDEXCODE in", values, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeNotIn(List<String> values) {
            addCriterion("INDEXCODE not in", values, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeBetween(String value1, String value2) {
            addCriterion("INDEXCODE between", value1, value2, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeNotBetween(String value1, String value2) {
            addCriterion("INDEXCODE not between", value1, value2, "indexcode");
            return (Criteria) this;
        }

        public Criteria andParentUuidIsNull() {
            addCriterion("PARENT_UUID is null");
            return (Criteria) this;
        }

        public Criteria andParentUuidIsNotNull() {
            addCriterion("PARENT_UUID is not null");
            return (Criteria) this;
        }

        public Criteria andParentUuidEqualTo(String value) {
            addCriterion("PARENT_UUID =", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidNotEqualTo(String value) {
            addCriterion("PARENT_UUID <>", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidGreaterThan(String value) {
            addCriterion("PARENT_UUID >", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_UUID >=", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidLessThan(String value) {
            addCriterion("PARENT_UUID <", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidLessThanOrEqualTo(String value) {
            addCriterion("PARENT_UUID <=", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidLike(String value) {
            addCriterion("PARENT_UUID like", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidNotLike(String value) {
            addCriterion("PARENT_UUID not like", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidIn(List<String> values) {
            addCriterion("PARENT_UUID in", values, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidNotIn(List<String> values) {
            addCriterion("PARENT_UUID not in", values, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidBetween(String value1, String value2) {
            addCriterion("PARENT_UUID between", value1, value2, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidNotBetween(String value1, String value2) {
            addCriterion("PARENT_UUID not between", value1, value2, "parentUuid");
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