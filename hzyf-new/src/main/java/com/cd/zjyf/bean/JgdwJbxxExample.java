package com.cd.zjyf.bean;

import java.util.ArrayList;
import java.util.List;

public class JgdwJbxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JgdwJbxxExample() {
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

        public Criteria andJgdwmcIsNull() {
            addCriterion("JGDWMC is null");
            return (Criteria) this;
        }

        public Criteria andJgdwmcIsNotNull() {
            addCriterion("JGDWMC is not null");
            return (Criteria) this;
        }

        public Criteria andJgdwmcEqualTo(String value) {
            addCriterion("JGDWMC =", value, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andJgdwmcNotEqualTo(String value) {
            addCriterion("JGDWMC <>", value, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andJgdwmcGreaterThan(String value) {
            addCriterion("JGDWMC >", value, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andJgdwmcGreaterThanOrEqualTo(String value) {
            addCriterion("JGDWMC >=", value, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andJgdwmcLessThan(String value) {
            addCriterion("JGDWMC <", value, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andJgdwmcLessThanOrEqualTo(String value) {
            addCriterion("JGDWMC <=", value, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andJgdwmcLike(String value) {
            addCriterion("JGDWMC like", value, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andJgdwmcNotLike(String value) {
            addCriterion("JGDWMC not like", value, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andJgdwmcIn(List<String> values) {
            addCriterion("JGDWMC in", values, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andJgdwmcNotIn(List<String> values) {
            addCriterion("JGDWMC not in", values, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andJgdwmcBetween(String value1, String value2) {
            addCriterion("JGDWMC between", value1, value2, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andJgdwmcNotBetween(String value1, String value2) {
            addCriterion("JGDWMC not between", value1, value2, "jgdwmc");
            return (Criteria) this;
        }

        public Criteria andBmjbIsNull() {
            addCriterion("BMJB is null");
            return (Criteria) this;
        }

        public Criteria andBmjbIsNotNull() {
            addCriterion("BMJB is not null");
            return (Criteria) this;
        }

        public Criteria andBmjbEqualTo(String value) {
            addCriterion("BMJB =", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbNotEqualTo(String value) {
            addCriterion("BMJB <>", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbGreaterThan(String value) {
            addCriterion("BMJB >", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbGreaterThanOrEqualTo(String value) {
            addCriterion("BMJB >=", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbLessThan(String value) {
            addCriterion("BMJB <", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbLessThanOrEqualTo(String value) {
            addCriterion("BMJB <=", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbLike(String value) {
            addCriterion("BMJB like", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbNotLike(String value) {
            addCriterion("BMJB not like", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbIn(List<String> values) {
            addCriterion("BMJB in", values, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbNotIn(List<String> values) {
            addCriterion("BMJB not in", values, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbBetween(String value1, String value2) {
            addCriterion("BMJB between", value1, value2, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbNotBetween(String value1, String value2) {
            addCriterion("BMJB not between", value1, value2, "bmjb");
            return (Criteria) this;
        }

        public Criteria andXzqhIsNull() {
            addCriterion("XZQH is null");
            return (Criteria) this;
        }

        public Criteria andXzqhIsNotNull() {
            addCriterion("XZQH is not null");
            return (Criteria) this;
        }

        public Criteria andXzqhEqualTo(String value) {
            addCriterion("XZQH =", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhNotEqualTo(String value) {
            addCriterion("XZQH <>", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhGreaterThan(String value) {
            addCriterion("XZQH >", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhGreaterThanOrEqualTo(String value) {
            addCriterion("XZQH >=", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhLessThan(String value) {
            addCriterion("XZQH <", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhLessThanOrEqualTo(String value) {
            addCriterion("XZQH <=", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhLike(String value) {
            addCriterion("XZQH like", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhNotLike(String value) {
            addCriterion("XZQH not like", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhIn(List<String> values) {
            addCriterion("XZQH in", values, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhNotIn(List<String> values) {
            addCriterion("XZQH not in", values, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhBetween(String value1, String value2) {
            addCriterion("XZQH between", value1, value2, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhNotBetween(String value1, String value2) {
            addCriterion("XZQH not between", value1, value2, "xzqh");
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