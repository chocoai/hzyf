package com.cd.zjyf.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class YfappVersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YfappVersionExample() {
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

        public Criteria andAppkeyIsNull() {
            addCriterion("APPKEY is null");
            return (Criteria) this;
        }

        public Criteria andAppkeyIsNotNull() {
            addCriterion("APPKEY is not null");
            return (Criteria) this;
        }

        public Criteria andAppkeyEqualTo(String value) {
            addCriterion("APPKEY =", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotEqualTo(String value) {
            addCriterion("APPKEY <>", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyGreaterThan(String value) {
            addCriterion("APPKEY >", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyGreaterThanOrEqualTo(String value) {
            addCriterion("APPKEY >=", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyLessThan(String value) {
            addCriterion("APPKEY <", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyLessThanOrEqualTo(String value) {
            addCriterion("APPKEY <=", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyLike(String value) {
            addCriterion("APPKEY like", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotLike(String value) {
            addCriterion("APPKEY not like", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyIn(List<String> values) {
            addCriterion("APPKEY in", values, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotIn(List<String> values) {
            addCriterion("APPKEY not in", values, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyBetween(String value1, String value2) {
            addCriterion("APPKEY between", value1, value2, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotBetween(String value1, String value2) {
            addCriterion("APPKEY not between", value1, value2, "appkey");
            return (Criteria) this;
        }

        public Criteria andByhIsNull() {
            addCriterion("BYH is null");
            return (Criteria) this;
        }

        public Criteria andByhIsNotNull() {
            addCriterion("BYH is not null");
            return (Criteria) this;
        }

        public Criteria andByhEqualTo(Short value) {
            addCriterion("BYH =", value, "byh");
            return (Criteria) this;
        }

        public Criteria andByhNotEqualTo(Short value) {
            addCriterion("BYH <>", value, "byh");
            return (Criteria) this;
        }

        public Criteria andByhGreaterThan(Short value) {
            addCriterion("BYH >", value, "byh");
            return (Criteria) this;
        }

        public Criteria andByhGreaterThanOrEqualTo(Short value) {
            addCriterion("BYH >=", value, "byh");
            return (Criteria) this;
        }

        public Criteria andByhLessThan(Short value) {
            addCriterion("BYH <", value, "byh");
            return (Criteria) this;
        }

        public Criteria andByhLessThanOrEqualTo(Short value) {
            addCriterion("BYH <=", value, "byh");
            return (Criteria) this;
        }

        public Criteria andByhIn(List<Short> values) {
            addCriterion("BYH in", values, "byh");
            return (Criteria) this;
        }

        public Criteria andByhNotIn(List<Short> values) {
            addCriterion("BYH not in", values, "byh");
            return (Criteria) this;
        }

        public Criteria andByhBetween(Short value1, Short value2) {
            addCriterion("BYH between", value1, value2, "byh");
            return (Criteria) this;
        }

        public Criteria andByhNotBetween(Short value1, Short value2) {
            addCriterion("BYH not between", value1, value2, "byh");
            return (Criteria) this;
        }

        public Criteria andBbhIsNull() {
            addCriterion("BBH is null");
            return (Criteria) this;
        }

        public Criteria andBbhIsNotNull() {
            addCriterion("BBH is not null");
            return (Criteria) this;
        }

        public Criteria andBbhEqualTo(String value) {
            addCriterion("BBH =", value, "bbh");
            return (Criteria) this;
        }

        public Criteria andBbhNotEqualTo(String value) {
            addCriterion("BBH <>", value, "bbh");
            return (Criteria) this;
        }

        public Criteria andBbhGreaterThan(String value) {
            addCriterion("BBH >", value, "bbh");
            return (Criteria) this;
        }

        public Criteria andBbhGreaterThanOrEqualTo(String value) {
            addCriterion("BBH >=", value, "bbh");
            return (Criteria) this;
        }

        public Criteria andBbhLessThan(String value) {
            addCriterion("BBH <", value, "bbh");
            return (Criteria) this;
        }

        public Criteria andBbhLessThanOrEqualTo(String value) {
            addCriterion("BBH <=", value, "bbh");
            return (Criteria) this;
        }

        public Criteria andBbhLike(String value) {
            addCriterion("BBH like", value, "bbh");
            return (Criteria) this;
        }

        public Criteria andBbhNotLike(String value) {
            addCriterion("BBH not like", value, "bbh");
            return (Criteria) this;
        }

        public Criteria andBbhIn(List<String> values) {
            addCriterion("BBH in", values, "bbh");
            return (Criteria) this;
        }

        public Criteria andBbhNotIn(List<String> values) {
            addCriterion("BBH not in", values, "bbh");
            return (Criteria) this;
        }

        public Criteria andBbhBetween(String value1, String value2) {
            addCriterion("BBH between", value1, value2, "bbh");
            return (Criteria) this;
        }

        public Criteria andBbhNotBetween(String value1, String value2) {
            addCriterion("BBH not between", value1, value2, "bbh");
            return (Criteria) this;
        }

        public Criteria andRjdxIsNull() {
            addCriterion("RJDX is null");
            return (Criteria) this;
        }

        public Criteria andRjdxIsNotNull() {
            addCriterion("RJDX is not null");
            return (Criteria) this;
        }

        public Criteria andRjdxEqualTo(String value) {
            addCriterion("RJDX =", value, "rjdx");
            return (Criteria) this;
        }

        public Criteria andRjdxNotEqualTo(String value) {
            addCriterion("RJDX <>", value, "rjdx");
            return (Criteria) this;
        }

        public Criteria andRjdxGreaterThan(String value) {
            addCriterion("RJDX >", value, "rjdx");
            return (Criteria) this;
        }

        public Criteria andRjdxGreaterThanOrEqualTo(String value) {
            addCriterion("RJDX >=", value, "rjdx");
            return (Criteria) this;
        }

        public Criteria andRjdxLessThan(String value) {
            addCriterion("RJDX <", value, "rjdx");
            return (Criteria) this;
        }

        public Criteria andRjdxLessThanOrEqualTo(String value) {
            addCriterion("RJDX <=", value, "rjdx");
            return (Criteria) this;
        }

        public Criteria andRjdxLike(String value) {
            addCriterion("RJDX like", value, "rjdx");
            return (Criteria) this;
        }

        public Criteria andRjdxNotLike(String value) {
            addCriterion("RJDX not like", value, "rjdx");
            return (Criteria) this;
        }

        public Criteria andRjdxIn(List<String> values) {
            addCriterion("RJDX in", values, "rjdx");
            return (Criteria) this;
        }

        public Criteria andRjdxNotIn(List<String> values) {
            addCriterion("RJDX not in", values, "rjdx");
            return (Criteria) this;
        }

        public Criteria andRjdxBetween(String value1, String value2) {
            addCriterion("RJDX between", value1, value2, "rjdx");
            return (Criteria) this;
        }

        public Criteria andRjdxNotBetween(String value1, String value2) {
            addCriterion("RJDX not between", value1, value2, "rjdx");
            return (Criteria) this;
        }

        public Criteria andGxsmIsNull() {
            addCriterion("GXSM is null");
            return (Criteria) this;
        }

        public Criteria andGxsmIsNotNull() {
            addCriterion("GXSM is not null");
            return (Criteria) this;
        }

        public Criteria andGxsmEqualTo(String value) {
            addCriterion("GXSM =", value, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxsmNotEqualTo(String value) {
            addCriterion("GXSM <>", value, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxsmGreaterThan(String value) {
            addCriterion("GXSM >", value, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxsmGreaterThanOrEqualTo(String value) {
            addCriterion("GXSM >=", value, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxsmLessThan(String value) {
            addCriterion("GXSM <", value, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxsmLessThanOrEqualTo(String value) {
            addCriterion("GXSM <=", value, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxsmLike(String value) {
            addCriterion("GXSM like", value, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxsmNotLike(String value) {
            addCriterion("GXSM not like", value, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxsmIn(List<String> values) {
            addCriterion("GXSM in", values, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxsmNotIn(List<String> values) {
            addCriterion("GXSM not in", values, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxsmBetween(String value1, String value2) {
            addCriterion("GXSM between", value1, value2, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxsmNotBetween(String value1, String value2) {
            addCriterion("GXSM not between", value1, value2, "gxsm");
            return (Criteria) this;
        }

        public Criteria andGxdzIsNull() {
            addCriterion("GXDZ is null");
            return (Criteria) this;
        }

        public Criteria andGxdzIsNotNull() {
            addCriterion("GXDZ is not null");
            return (Criteria) this;
        }

        public Criteria andGxdzEqualTo(String value) {
            addCriterion("GXDZ =", value, "gxdz");
            return (Criteria) this;
        }

        public Criteria andGxdzNotEqualTo(String value) {
            addCriterion("GXDZ <>", value, "gxdz");
            return (Criteria) this;
        }

        public Criteria andGxdzGreaterThan(String value) {
            addCriterion("GXDZ >", value, "gxdz");
            return (Criteria) this;
        }

        public Criteria andGxdzGreaterThanOrEqualTo(String value) {
            addCriterion("GXDZ >=", value, "gxdz");
            return (Criteria) this;
        }

        public Criteria andGxdzLessThan(String value) {
            addCriterion("GXDZ <", value, "gxdz");
            return (Criteria) this;
        }

        public Criteria andGxdzLessThanOrEqualTo(String value) {
            addCriterion("GXDZ <=", value, "gxdz");
            return (Criteria) this;
        }

        public Criteria andGxdzLike(String value) {
            addCriterion("GXDZ like", value, "gxdz");
            return (Criteria) this;
        }

        public Criteria andGxdzNotLike(String value) {
            addCriterion("GXDZ not like", value, "gxdz");
            return (Criteria) this;
        }

        public Criteria andGxdzIn(List<String> values) {
            addCriterion("GXDZ in", values, "gxdz");
            return (Criteria) this;
        }

        public Criteria andGxdzNotIn(List<String> values) {
            addCriterion("GXDZ not in", values, "gxdz");
            return (Criteria) this;
        }

        public Criteria andGxdzBetween(String value1, String value2) {
            addCriterion("GXDZ between", value1, value2, "gxdz");
            return (Criteria) this;
        }

        public Criteria andGxdzNotBetween(String value1, String value2) {
            addCriterion("GXDZ not between", value1, value2, "gxdz");
            return (Criteria) this;
        }

        public Criteria andFbrqIsNull() {
            addCriterion("FBRQ is null");
            return (Criteria) this;
        }

        public Criteria andFbrqIsNotNull() {
            addCriterion("FBRQ is not null");
            return (Criteria) this;
        }

        public Criteria andFbrqEqualTo(Date value) {
            addCriterionForJDBCDate("FBRQ =", value, "fbrq");
            return (Criteria) this;
        }

        public Criteria andFbrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("FBRQ <>", value, "fbrq");
            return (Criteria) this;
        }

        public Criteria andFbrqGreaterThan(Date value) {
            addCriterionForJDBCDate("FBRQ >", value, "fbrq");
            return (Criteria) this;
        }

        public Criteria andFbrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FBRQ >=", value, "fbrq");
            return (Criteria) this;
        }

        public Criteria andFbrqLessThan(Date value) {
            addCriterionForJDBCDate("FBRQ <", value, "fbrq");
            return (Criteria) this;
        }

        public Criteria andFbrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FBRQ <=", value, "fbrq");
            return (Criteria) this;
        }

        public Criteria andFbrqIn(List<Date> values) {
            addCriterionForJDBCDate("FBRQ in", values, "fbrq");
            return (Criteria) this;
        }

        public Criteria andFbrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("FBRQ not in", values, "fbrq");
            return (Criteria) this;
        }

        public Criteria andFbrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FBRQ between", value1, value2, "fbrq");
            return (Criteria) this;
        }

        public Criteria andFbrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FBRQ not between", value1, value2, "fbrq");
            return (Criteria) this;
        }

        public Criteria andZxbbIsNull() {
            addCriterion("ZXBB is null");
            return (Criteria) this;
        }

        public Criteria andZxbbIsNotNull() {
            addCriterion("ZXBB is not null");
            return (Criteria) this;
        }

        public Criteria andZxbbEqualTo(String value) {
            addCriterion("ZXBB =", value, "zxbb");
            return (Criteria) this;
        }

        public Criteria andZxbbNotEqualTo(String value) {
            addCriterion("ZXBB <>", value, "zxbb");
            return (Criteria) this;
        }

        public Criteria andZxbbGreaterThan(String value) {
            addCriterion("ZXBB >", value, "zxbb");
            return (Criteria) this;
        }

        public Criteria andZxbbGreaterThanOrEqualTo(String value) {
            addCriterion("ZXBB >=", value, "zxbb");
            return (Criteria) this;
        }

        public Criteria andZxbbLessThan(String value) {
            addCriterion("ZXBB <", value, "zxbb");
            return (Criteria) this;
        }

        public Criteria andZxbbLessThanOrEqualTo(String value) {
            addCriterion("ZXBB <=", value, "zxbb");
            return (Criteria) this;
        }

        public Criteria andZxbbLike(String value) {
            addCriterion("ZXBB like", value, "zxbb");
            return (Criteria) this;
        }

        public Criteria andZxbbNotLike(String value) {
            addCriterion("ZXBB not like", value, "zxbb");
            return (Criteria) this;
        }

        public Criteria andZxbbIn(List<String> values) {
            addCriterion("ZXBB in", values, "zxbb");
            return (Criteria) this;
        }

        public Criteria andZxbbNotIn(List<String> values) {
            addCriterion("ZXBB not in", values, "zxbb");
            return (Criteria) this;
        }

        public Criteria andZxbbBetween(String value1, String value2) {
            addCriterion("ZXBB between", value1, value2, "zxbb");
            return (Criteria) this;
        }

        public Criteria andZxbbNotBetween(String value1, String value2) {
            addCriterion("ZXBB not between", value1, value2, "zxbb");
            return (Criteria) this;
        }

        public Criteria andGxlxIsNull() {
            addCriterion("GXLX is null");
            return (Criteria) this;
        }

        public Criteria andGxlxIsNotNull() {
            addCriterion("GXLX is not null");
            return (Criteria) this;
        }

        public Criteria andGxlxEqualTo(String value) {
            addCriterion("GXLX =", value, "gxlx");
            return (Criteria) this;
        }

        public Criteria andGxlxNotEqualTo(String value) {
            addCriterion("GXLX <>", value, "gxlx");
            return (Criteria) this;
        }

        public Criteria andGxlxGreaterThan(String value) {
            addCriterion("GXLX >", value, "gxlx");
            return (Criteria) this;
        }

        public Criteria andGxlxGreaterThanOrEqualTo(String value) {
            addCriterion("GXLX >=", value, "gxlx");
            return (Criteria) this;
        }

        public Criteria andGxlxLessThan(String value) {
            addCriterion("GXLX <", value, "gxlx");
            return (Criteria) this;
        }

        public Criteria andGxlxLessThanOrEqualTo(String value) {
            addCriterion("GXLX <=", value, "gxlx");
            return (Criteria) this;
        }

        public Criteria andGxlxLike(String value) {
            addCriterion("GXLX like", value, "gxlx");
            return (Criteria) this;
        }

        public Criteria andGxlxNotLike(String value) {
            addCriterion("GXLX not like", value, "gxlx");
            return (Criteria) this;
        }

        public Criteria andGxlxIn(List<String> values) {
            addCriterion("GXLX in", values, "gxlx");
            return (Criteria) this;
        }

        public Criteria andGxlxNotIn(List<String> values) {
            addCriterion("GXLX not in", values, "gxlx");
            return (Criteria) this;
        }

        public Criteria andGxlxBetween(String value1, String value2) {
            addCriterion("GXLX between", value1, value2, "gxlx");
            return (Criteria) this;
        }

        public Criteria andGxlxNotBetween(String value1, String value2) {
            addCriterion("GXLX not between", value1, value2, "gxlx");
            return (Criteria) this;
        }

        public Criteria andCjridIsNull() {
            addCriterion("CJRID is null");
            return (Criteria) this;
        }

        public Criteria andCjridIsNotNull() {
            addCriterion("CJRID is not null");
            return (Criteria) this;
        }

        public Criteria andCjridEqualTo(String value) {
            addCriterion("CJRID =", value, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjridNotEqualTo(String value) {
            addCriterion("CJRID <>", value, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjridGreaterThan(String value) {
            addCriterion("CJRID >", value, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjridGreaterThanOrEqualTo(String value) {
            addCriterion("CJRID >=", value, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjridLessThan(String value) {
            addCriterion("CJRID <", value, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjridLessThanOrEqualTo(String value) {
            addCriterion("CJRID <=", value, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjridLike(String value) {
            addCriterion("CJRID like", value, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjridNotLike(String value) {
            addCriterion("CJRID not like", value, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjridIn(List<String> values) {
            addCriterion("CJRID in", values, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjridNotIn(List<String> values) {
            addCriterion("CJRID not in", values, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjridBetween(String value1, String value2) {
            addCriterion("CJRID between", value1, value2, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjridNotBetween(String value1, String value2) {
            addCriterion("CJRID not between", value1, value2, "cjrid");
            return (Criteria) this;
        }

        public Criteria andCjsjIsNull() {
            addCriterion("CJSJ is null");
            return (Criteria) this;
        }

        public Criteria andCjsjIsNotNull() {
            addCriterion("CJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andCjsjEqualTo(Date value) {
            addCriterionForJDBCDate("CJSJ =", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("CJSJ <>", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjGreaterThan(Date value) {
            addCriterionForJDBCDate("CJSJ >", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CJSJ >=", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjLessThan(Date value) {
            addCriterionForJDBCDate("CJSJ <", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CJSJ <=", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjIn(List<Date> values) {
            addCriterionForJDBCDate("CJSJ in", values, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("CJSJ not in", values, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CJSJ between", value1, value2, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CJSJ not between", value1, value2, "cjsj");
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