package com.cd.zjyf.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class YlfwJsdjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YlfwJsdjExample() {
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

        public Criteria andCsdidIsNull() {
            addCriterion("CSDID is null");
            return (Criteria) this;
        }

        public Criteria andCsdidIsNotNull() {
            addCriterion("CSDID is not null");
            return (Criteria) this;
        }

        public Criteria andCsdidEqualTo(String value) {
            addCriterion("CSDID =", value, "csdid");
            return (Criteria) this;
        }

        public Criteria andCsdidNotEqualTo(String value) {
            addCriterion("CSDID <>", value, "csdid");
            return (Criteria) this;
        }

        public Criteria andCsdidGreaterThan(String value) {
            addCriterion("CSDID >", value, "csdid");
            return (Criteria) this;
        }

        public Criteria andCsdidGreaterThanOrEqualTo(String value) {
            addCriterion("CSDID >=", value, "csdid");
            return (Criteria) this;
        }

        public Criteria andCsdidLessThan(String value) {
            addCriterion("CSDID <", value, "csdid");
            return (Criteria) this;
        }

        public Criteria andCsdidLessThanOrEqualTo(String value) {
            addCriterion("CSDID <=", value, "csdid");
            return (Criteria) this;
        }

        public Criteria andCsdidLike(String value) {
            addCriterion("CSDID like", value, "csdid");
            return (Criteria) this;
        }

        public Criteria andCsdidNotLike(String value) {
            addCriterion("CSDID not like", value, "csdid");
            return (Criteria) this;
        }

        public Criteria andCsdidIn(List<String> values) {
            addCriterion("CSDID in", values, "csdid");
            return (Criteria) this;
        }

        public Criteria andCsdidNotIn(List<String> values) {
            addCriterion("CSDID not in", values, "csdid");
            return (Criteria) this;
        }

        public Criteria andCsdidBetween(String value1, String value2) {
            addCriterion("CSDID between", value1, value2, "csdid");
            return (Criteria) this;
        }

        public Criteria andCsdidNotBetween(String value1, String value2) {
            addCriterion("CSDID not between", value1, value2, "csdid");
            return (Criteria) this;
        }

        public Criteria andZcdidIsNull() {
            addCriterion("ZCDID is null");
            return (Criteria) this;
        }

        public Criteria andZcdidIsNotNull() {
            addCriterion("ZCDID is not null");
            return (Criteria) this;
        }

        public Criteria andZcdidEqualTo(String value) {
            addCriterion("ZCDID =", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidNotEqualTo(String value) {
            addCriterion("ZCDID <>", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidGreaterThan(String value) {
            addCriterion("ZCDID >", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidGreaterThanOrEqualTo(String value) {
            addCriterion("ZCDID >=", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidLessThan(String value) {
            addCriterion("ZCDID <", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidLessThanOrEqualTo(String value) {
            addCriterion("ZCDID <=", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidLike(String value) {
            addCriterion("ZCDID like", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidNotLike(String value) {
            addCriterion("ZCDID not like", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidIn(List<String> values) {
            addCriterion("ZCDID in", values, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidNotIn(List<String> values) {
            addCriterion("ZCDID not in", values, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidBetween(String value1, String value2) {
            addCriterion("ZCDID between", value1, value2, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidNotBetween(String value1, String value2) {
            addCriterion("ZCDID not between", value1, value2, "zcdid");
            return (Criteria) this;
        }

        public Criteria andJstimeIsNull() {
            addCriterion("JSTIME is null");
            return (Criteria) this;
        }

        public Criteria andJstimeIsNotNull() {
            addCriterion("JSTIME is not null");
            return (Criteria) this;
        }

        public Criteria andJstimeEqualTo(Date value) {
            addCriterionForJDBCDate("JSTIME =", value, "jstime");
            return (Criteria) this;
        }

        public Criteria andJstimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("JSTIME <>", value, "jstime");
            return (Criteria) this;
        }

        public Criteria andJstimeGreaterThan(Date value) {
            addCriterionForJDBCDate("JSTIME >", value, "jstime");
            return (Criteria) this;
        }

        public Criteria andJstimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("JSTIME >=", value, "jstime");
            return (Criteria) this;
        }

        public Criteria andJstimeLessThan(Date value) {
            addCriterionForJDBCDate("JSTIME <", value, "jstime");
            return (Criteria) this;
        }

        public Criteria andJstimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("JSTIME <=", value, "jstime");
            return (Criteria) this;
        }

        public Criteria andJstimeIn(List<Date> values) {
            addCriterionForJDBCDate("JSTIME in", values, "jstime");
            return (Criteria) this;
        }

        public Criteria andJstimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("JSTIME not in", values, "jstime");
            return (Criteria) this;
        }

        public Criteria andJstimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("JSTIME between", value1, value2, "jstime");
            return (Criteria) this;
        }

        public Criteria andJstimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("JSTIME not between", value1, value2, "jstime");
            return (Criteria) this;
        }

        public Criteria andLxIsNull() {
            addCriterion("LX is null");
            return (Criteria) this;
        }

        public Criteria andLxIsNotNull() {
            addCriterion("LX is not null");
            return (Criteria) this;
        }

        public Criteria andLxEqualTo(String value) {
            addCriterion("LX =", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotEqualTo(String value) {
            addCriterion("LX <>", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxGreaterThan(String value) {
            addCriterion("LX >", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxGreaterThanOrEqualTo(String value) {
            addCriterion("LX >=", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxLessThan(String value) {
            addCriterion("LX <", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxLessThanOrEqualTo(String value) {
            addCriterion("LX <=", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxLike(String value) {
            addCriterion("LX like", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotLike(String value) {
            addCriterion("LX not like", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxIn(List<String> values) {
            addCriterion("LX in", values, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotIn(List<String> values) {
            addCriterion("LX not in", values, "lx");
            return (Criteria) this;
        }

        public Criteria andLxBetween(String value1, String value2) {
            addCriterion("LX between", value1, value2, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotBetween(String value1, String value2) {
            addCriterion("LX not between", value1, value2, "lx");
            return (Criteria) this;
        }

        public Criteria andSlIsNull() {
            addCriterion("SL is null");
            return (Criteria) this;
        }

        public Criteria andSlIsNotNull() {
            addCriterion("SL is not null");
            return (Criteria) this;
        }

        public Criteria andSlEqualTo(BigDecimal value) {
            addCriterion("SL =", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotEqualTo(BigDecimal value) {
            addCriterion("SL <>", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlGreaterThan(BigDecimal value) {
            addCriterion("SL >", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SL >=", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlLessThan(BigDecimal value) {
            addCriterion("SL <", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SL <=", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlIn(List<BigDecimal> values) {
            addCriterion("SL in", values, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotIn(List<BigDecimal> values) {
            addCriterion("SL not in", values, "sl");
            return (Criteria) this;
        }

        public Criteria andSlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SL between", value1, value2, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SL not between", value1, value2, "sl");
            return (Criteria) this;
        }

        public Criteria andZlIsNull() {
            addCriterion("ZL is null");
            return (Criteria) this;
        }

        public Criteria andZlIsNotNull() {
            addCriterion("ZL is not null");
            return (Criteria) this;
        }

        public Criteria andZlEqualTo(BigDecimal value) {
            addCriterion("ZL =", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotEqualTo(BigDecimal value) {
            addCriterion("ZL <>", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlGreaterThan(BigDecimal value) {
            addCriterion("ZL >", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZL >=", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlLessThan(BigDecimal value) {
            addCriterion("ZL <", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZL <=", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlIn(List<BigDecimal> values) {
            addCriterion("ZL in", values, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotIn(List<BigDecimal> values) {
            addCriterion("ZL not in", values, "zl");
            return (Criteria) this;
        }

        public Criteria andZlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZL between", value1, value2, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZL not between", value1, value2, "zl");
            return (Criteria) this;
        }

        public Criteria andJsqkIsNull() {
            addCriterion("JSQK is null");
            return (Criteria) this;
        }

        public Criteria andJsqkIsNotNull() {
            addCriterion("JSQK is not null");
            return (Criteria) this;
        }

        public Criteria andJsqkEqualTo(String value) {
            addCriterion("JSQK =", value, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJsqkNotEqualTo(String value) {
            addCriterion("JSQK <>", value, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJsqkGreaterThan(String value) {
            addCriterion("JSQK >", value, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJsqkGreaterThanOrEqualTo(String value) {
            addCriterion("JSQK >=", value, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJsqkLessThan(String value) {
            addCriterion("JSQK <", value, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJsqkLessThanOrEqualTo(String value) {
            addCriterion("JSQK <=", value, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJsqkLike(String value) {
            addCriterion("JSQK like", value, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJsqkNotLike(String value) {
            addCriterion("JSQK not like", value, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJsqkIn(List<String> values) {
            addCriterion("JSQK in", values, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJsqkNotIn(List<String> values) {
            addCriterion("JSQK not in", values, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJsqkBetween(String value1, String value2) {
            addCriterion("JSQK between", value1, value2, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJsqkNotBetween(String value1, String value2) {
            addCriterion("JSQK not between", value1, value2, "jsqk");
            return (Criteria) this;
        }

        public Criteria andJjlyIsNull() {
            addCriterion("JJLY is null");
            return (Criteria) this;
        }

        public Criteria andJjlyIsNotNull() {
            addCriterion("JJLY is not null");
            return (Criteria) this;
        }

        public Criteria andJjlyEqualTo(String value) {
            addCriterion("JJLY =", value, "jjly");
            return (Criteria) this;
        }

        public Criteria andJjlyNotEqualTo(String value) {
            addCriterion("JJLY <>", value, "jjly");
            return (Criteria) this;
        }

        public Criteria andJjlyGreaterThan(String value) {
            addCriterion("JJLY >", value, "jjly");
            return (Criteria) this;
        }

        public Criteria andJjlyGreaterThanOrEqualTo(String value) {
            addCriterion("JJLY >=", value, "jjly");
            return (Criteria) this;
        }

        public Criteria andJjlyLessThan(String value) {
            addCriterion("JJLY <", value, "jjly");
            return (Criteria) this;
        }

        public Criteria andJjlyLessThanOrEqualTo(String value) {
            addCriterion("JJLY <=", value, "jjly");
            return (Criteria) this;
        }

        public Criteria andJjlyLike(String value) {
            addCriterion("JJLY like", value, "jjly");
            return (Criteria) this;
        }

        public Criteria andJjlyNotLike(String value) {
            addCriterion("JJLY not like", value, "jjly");
            return (Criteria) this;
        }

        public Criteria andJjlyIn(List<String> values) {
            addCriterion("JJLY in", values, "jjly");
            return (Criteria) this;
        }

        public Criteria andJjlyNotIn(List<String> values) {
            addCriterion("JJLY not in", values, "jjly");
            return (Criteria) this;
        }

        public Criteria andJjlyBetween(String value1, String value2) {
            addCriterion("JJLY between", value1, value2, "jjly");
            return (Criteria) this;
        }

        public Criteria andJjlyNotBetween(String value1, String value2) {
            addCriterion("JJLY not between", value1, value2, "jjly");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("ENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("ENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ENDTIME >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("ENDTIME <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("ENDTIME in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ENDTIME not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENDTIME between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENDTIME not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andQsridIsNull() {
            addCriterion("QSRID is null");
            return (Criteria) this;
        }

        public Criteria andQsridIsNotNull() {
            addCriterion("QSRID is not null");
            return (Criteria) this;
        }

        public Criteria andQsridEqualTo(String value) {
            addCriterion("QSRID =", value, "qsrid");
            return (Criteria) this;
        }

        public Criteria andQsridNotEqualTo(String value) {
            addCriterion("QSRID <>", value, "qsrid");
            return (Criteria) this;
        }

        public Criteria andQsridGreaterThan(String value) {
            addCriterion("QSRID >", value, "qsrid");
            return (Criteria) this;
        }

        public Criteria andQsridGreaterThanOrEqualTo(String value) {
            addCriterion("QSRID >=", value, "qsrid");
            return (Criteria) this;
        }

        public Criteria andQsridLessThan(String value) {
            addCriterion("QSRID <", value, "qsrid");
            return (Criteria) this;
        }

        public Criteria andQsridLessThanOrEqualTo(String value) {
            addCriterion("QSRID <=", value, "qsrid");
            return (Criteria) this;
        }

        public Criteria andQsridLike(String value) {
            addCriterion("QSRID like", value, "qsrid");
            return (Criteria) this;
        }

        public Criteria andQsridNotLike(String value) {
            addCriterion("QSRID not like", value, "qsrid");
            return (Criteria) this;
        }

        public Criteria andQsridIn(List<String> values) {
            addCriterion("QSRID in", values, "qsrid");
            return (Criteria) this;
        }

        public Criteria andQsridNotIn(List<String> values) {
            addCriterion("QSRID not in", values, "qsrid");
            return (Criteria) this;
        }

        public Criteria andQsridBetween(String value1, String value2) {
            addCriterion("QSRID between", value1, value2, "qsrid");
            return (Criteria) this;
        }

        public Criteria andQsridNotBetween(String value1, String value2) {
            addCriterion("QSRID not between", value1, value2, "qsrid");
            return (Criteria) this;
        }

        public Criteria andTgzidIsNull() {
            addCriterion("TGZID is null");
            return (Criteria) this;
        }

        public Criteria andTgzidIsNotNull() {
            addCriterion("TGZID is not null");
            return (Criteria) this;
        }

        public Criteria andTgzidEqualTo(String value) {
            addCriterion("TGZID =", value, "tgzid");
            return (Criteria) this;
        }

        public Criteria andTgzidNotEqualTo(String value) {
            addCriterion("TGZID <>", value, "tgzid");
            return (Criteria) this;
        }

        public Criteria andTgzidGreaterThan(String value) {
            addCriterion("TGZID >", value, "tgzid");
            return (Criteria) this;
        }

        public Criteria andTgzidGreaterThanOrEqualTo(String value) {
            addCriterion("TGZID >=", value, "tgzid");
            return (Criteria) this;
        }

        public Criteria andTgzidLessThan(String value) {
            addCriterion("TGZID <", value, "tgzid");
            return (Criteria) this;
        }

        public Criteria andTgzidLessThanOrEqualTo(String value) {
            addCriterion("TGZID <=", value, "tgzid");
            return (Criteria) this;
        }

        public Criteria andTgzidLike(String value) {
            addCriterion("TGZID like", value, "tgzid");
            return (Criteria) this;
        }

        public Criteria andTgzidNotLike(String value) {
            addCriterion("TGZID not like", value, "tgzid");
            return (Criteria) this;
        }

        public Criteria andTgzidIn(List<String> values) {
            addCriterion("TGZID in", values, "tgzid");
            return (Criteria) this;
        }

        public Criteria andTgzidNotIn(List<String> values) {
            addCriterion("TGZID not in", values, "tgzid");
            return (Criteria) this;
        }

        public Criteria andTgzidBetween(String value1, String value2) {
            addCriterion("TGZID between", value1, value2, "tgzid");
            return (Criteria) this;
        }

        public Criteria andTgzidNotBetween(String value1, String value2) {
            addCriterion("TGZID not between", value1, value2, "tgzid");
            return (Criteria) this;
        }

        public Criteria andJsridIsNull() {
            addCriterion("JSRID is null");
            return (Criteria) this;
        }

        public Criteria andJsridIsNotNull() {
            addCriterion("JSRID is not null");
            return (Criteria) this;
        }

        public Criteria andJsridEqualTo(String value) {
            addCriterion("JSRID =", value, "jsrid");
            return (Criteria) this;
        }

        public Criteria andJsridNotEqualTo(String value) {
            addCriterion("JSRID <>", value, "jsrid");
            return (Criteria) this;
        }

        public Criteria andJsridGreaterThan(String value) {
            addCriterion("JSRID >", value, "jsrid");
            return (Criteria) this;
        }

        public Criteria andJsridGreaterThanOrEqualTo(String value) {
            addCriterion("JSRID >=", value, "jsrid");
            return (Criteria) this;
        }

        public Criteria andJsridLessThan(String value) {
            addCriterion("JSRID <", value, "jsrid");
            return (Criteria) this;
        }

        public Criteria andJsridLessThanOrEqualTo(String value) {
            addCriterion("JSRID <=", value, "jsrid");
            return (Criteria) this;
        }

        public Criteria andJsridLike(String value) {
            addCriterion("JSRID like", value, "jsrid");
            return (Criteria) this;
        }

        public Criteria andJsridNotLike(String value) {
            addCriterion("JSRID not like", value, "jsrid");
            return (Criteria) this;
        }

        public Criteria andJsridIn(List<String> values) {
            addCriterion("JSRID in", values, "jsrid");
            return (Criteria) this;
        }

        public Criteria andJsridNotIn(List<String> values) {
            addCriterion("JSRID not in", values, "jsrid");
            return (Criteria) this;
        }

        public Criteria andJsridBetween(String value1, String value2) {
            addCriterion("JSRID between", value1, value2, "jsrid");
            return (Criteria) this;
        }

        public Criteria andJsridNotBetween(String value1, String value2) {
            addCriterion("JSRID not between", value1, value2, "jsrid");
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