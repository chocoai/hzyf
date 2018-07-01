package com.cd.zjyf.bean;

import java.util.ArrayList;
import java.util.List;

public class AppUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppUserExample() {
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

        public Criteria andXmIsNull() {
            addCriterion("XM is null");
            return (Criteria) this;
        }

        public Criteria andXmIsNotNull() {
            addCriterion("XM is not null");
            return (Criteria) this;
        }

        public Criteria andXmEqualTo(String value) {
            addCriterion("XM =", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotEqualTo(String value) {
            addCriterion("XM <>", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThan(String value) {
            addCriterion("XM >", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThanOrEqualTo(String value) {
            addCriterion("XM >=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThan(String value) {
            addCriterion("XM <", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThanOrEqualTo(String value) {
            addCriterion("XM <=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLike(String value) {
            addCriterion("XM like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotLike(String value) {
            addCriterion("XM not like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmIn(List<String> values) {
            addCriterion("XM in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotIn(List<String> values) {
            addCriterion("XM not in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmBetween(String value1, String value2) {
            addCriterion("XM between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotBetween(String value1, String value2) {
            addCriterion("XM not between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andSjhIsNull() {
            addCriterion("SJH is null");
            return (Criteria) this;
        }

        public Criteria andSjhIsNotNull() {
            addCriterion("SJH is not null");
            return (Criteria) this;
        }

        public Criteria andSjhEqualTo(String value) {
            addCriterion("SJH =", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhNotEqualTo(String value) {
            addCriterion("SJH <>", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhGreaterThan(String value) {
            addCriterion("SJH >", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhGreaterThanOrEqualTo(String value) {
            addCriterion("SJH >=", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhLessThan(String value) {
            addCriterion("SJH <", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhLessThanOrEqualTo(String value) {
            addCriterion("SJH <=", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhLike(String value) {
            addCriterion("SJH like", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhNotLike(String value) {
            addCriterion("SJH not like", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhIn(List<String> values) {
            addCriterion("SJH in", values, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhNotIn(List<String> values) {
            addCriterion("SJH not in", values, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhBetween(String value1, String value2) {
            addCriterion("SJH between", value1, value2, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhNotBetween(String value1, String value2) {
            addCriterion("SJH not between", value1, value2, "sjh");
            return (Criteria) this;
        }

        public Criteria andMmIsNull() {
            addCriterion("MM is null");
            return (Criteria) this;
        }

        public Criteria andMmIsNotNull() {
            addCriterion("MM is not null");
            return (Criteria) this;
        }

        public Criteria andMmEqualTo(String value) {
            addCriterion("MM =", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotEqualTo(String value) {
            addCriterion("MM <>", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmGreaterThan(String value) {
            addCriterion("MM >", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmGreaterThanOrEqualTo(String value) {
            addCriterion("MM >=", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmLessThan(String value) {
            addCriterion("MM <", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmLessThanOrEqualTo(String value) {
            addCriterion("MM <=", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmLike(String value) {
            addCriterion("MM like", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotLike(String value) {
            addCriterion("MM not like", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmIn(List<String> values) {
            addCriterion("MM in", values, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotIn(List<String> values) {
            addCriterion("MM not in", values, "mm");
            return (Criteria) this;
        }

        public Criteria andMmBetween(String value1, String value2) {
            addCriterion("MM between", value1, value2, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotBetween(String value1, String value2) {
            addCriterion("MM not between", value1, value2, "mm");
            return (Criteria) this;
        }

        public Criteria andRylxIsNull() {
            addCriterion("RYLX is null");
            return (Criteria) this;
        }

        public Criteria andRylxIsNotNull() {
            addCriterion("RYLX is not null");
            return (Criteria) this;
        }

        public Criteria andRylxEqualTo(String value) {
            addCriterion("RYLX =", value, "rylx");
            return (Criteria) this;
        }

        public Criteria andRylxNotEqualTo(String value) {
            addCriterion("RYLX <>", value, "rylx");
            return (Criteria) this;
        }

        public Criteria andRylxGreaterThan(String value) {
            addCriterion("RYLX >", value, "rylx");
            return (Criteria) this;
        }

        public Criteria andRylxGreaterThanOrEqualTo(String value) {
            addCriterion("RYLX >=", value, "rylx");
            return (Criteria) this;
        }

        public Criteria andRylxLessThan(String value) {
            addCriterion("RYLX <", value, "rylx");
            return (Criteria) this;
        }

        public Criteria andRylxLessThanOrEqualTo(String value) {
            addCriterion("RYLX <=", value, "rylx");
            return (Criteria) this;
        }

        public Criteria andRylxLike(String value) {
            addCriterion("RYLX like", value, "rylx");
            return (Criteria) this;
        }

        public Criteria andRylxNotLike(String value) {
            addCriterion("RYLX not like", value, "rylx");
            return (Criteria) this;
        }

        public Criteria andRylxIn(List<String> values) {
            addCriterion("RYLX in", values, "rylx");
            return (Criteria) this;
        }

        public Criteria andRylxNotIn(List<String> values) {
            addCriterion("RYLX not in", values, "rylx");
            return (Criteria) this;
        }

        public Criteria andRylxBetween(String value1, String value2) {
            addCriterion("RYLX between", value1, value2, "rylx");
            return (Criteria) this;
        }

        public Criteria andRylxNotBetween(String value1, String value2) {
            addCriterion("RYLX not between", value1, value2, "rylx");
            return (Criteria) this;
        }

        public Criteria andJgdwidIsNull() {
            addCriterion("JGDWID is null");
            return (Criteria) this;
        }

        public Criteria andJgdwidIsNotNull() {
            addCriterion("JGDWID is not null");
            return (Criteria) this;
        }

        public Criteria andJgdwidEqualTo(String value) {
            addCriterion("JGDWID =", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidNotEqualTo(String value) {
            addCriterion("JGDWID <>", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidGreaterThan(String value) {
            addCriterion("JGDWID >", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidGreaterThanOrEqualTo(String value) {
            addCriterion("JGDWID >=", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidLessThan(String value) {
            addCriterion("JGDWID <", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidLessThanOrEqualTo(String value) {
            addCriterion("JGDWID <=", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidLike(String value) {
            addCriterion("JGDWID like", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidNotLike(String value) {
            addCriterion("JGDWID not like", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidIn(List<String> values) {
            addCriterion("JGDWID in", values, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidNotIn(List<String> values) {
            addCriterion("JGDWID not in", values, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidBetween(String value1, String value2) {
            addCriterion("JGDWID between", value1, value2, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidNotBetween(String value1, String value2) {
            addCriterion("JGDWID not between", value1, value2, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andRyzpIsNull() {
            addCriterion("RYZP is null");
            return (Criteria) this;
        }

        public Criteria andRyzpIsNotNull() {
            addCriterion("RYZP is not null");
            return (Criteria) this;
        }

        public Criteria andRyzpEqualTo(String value) {
            addCriterion("RYZP =", value, "ryzp");
            return (Criteria) this;
        }

        public Criteria andRyzpNotEqualTo(String value) {
            addCriterion("RYZP <>", value, "ryzp");
            return (Criteria) this;
        }

        public Criteria andRyzpGreaterThan(String value) {
            addCriterion("RYZP >", value, "ryzp");
            return (Criteria) this;
        }

        public Criteria andRyzpGreaterThanOrEqualTo(String value) {
            addCriterion("RYZP >=", value, "ryzp");
            return (Criteria) this;
        }

        public Criteria andRyzpLessThan(String value) {
            addCriterion("RYZP <", value, "ryzp");
            return (Criteria) this;
        }

        public Criteria andRyzpLessThanOrEqualTo(String value) {
            addCriterion("RYZP <=", value, "ryzp");
            return (Criteria) this;
        }

        public Criteria andRyzpLike(String value) {
            addCriterion("RYZP like", value, "ryzp");
            return (Criteria) this;
        }

        public Criteria andRyzpNotLike(String value) {
            addCriterion("RYZP not like", value, "ryzp");
            return (Criteria) this;
        }

        public Criteria andRyzpIn(List<String> values) {
            addCriterion("RYZP in", values, "ryzp");
            return (Criteria) this;
        }

        public Criteria andRyzpNotIn(List<String> values) {
            addCriterion("RYZP not in", values, "ryzp");
            return (Criteria) this;
        }

        public Criteria andRyzpBetween(String value1, String value2) {
            addCriterion("RYZP between", value1, value2, "ryzp");
            return (Criteria) this;
        }

        public Criteria andRyzpNotBetween(String value1, String value2) {
            addCriterion("RYZP not between", value1, value2, "ryzp");
            return (Criteria) this;
        }

        public Criteria andZgztIsNull() {
            addCriterion("ZGZT is null");
            return (Criteria) this;
        }

        public Criteria andZgztIsNotNull() {
            addCriterion("ZGZT is not null");
            return (Criteria) this;
        }

        public Criteria andZgztEqualTo(String value) {
            addCriterion("ZGZT =", value, "zgzt");
            return (Criteria) this;
        }

        public Criteria andZgztNotEqualTo(String value) {
            addCriterion("ZGZT <>", value, "zgzt");
            return (Criteria) this;
        }

        public Criteria andZgztGreaterThan(String value) {
            addCriterion("ZGZT >", value, "zgzt");
            return (Criteria) this;
        }

        public Criteria andZgztGreaterThanOrEqualTo(String value) {
            addCriterion("ZGZT >=", value, "zgzt");
            return (Criteria) this;
        }

        public Criteria andZgztLessThan(String value) {
            addCriterion("ZGZT <", value, "zgzt");
            return (Criteria) this;
        }

        public Criteria andZgztLessThanOrEqualTo(String value) {
            addCriterion("ZGZT <=", value, "zgzt");
            return (Criteria) this;
        }

        public Criteria andZgztLike(String value) {
            addCriterion("ZGZT like", value, "zgzt");
            return (Criteria) this;
        }

        public Criteria andZgztNotLike(String value) {
            addCriterion("ZGZT not like", value, "zgzt");
            return (Criteria) this;
        }

        public Criteria andZgztIn(List<String> values) {
            addCriterion("ZGZT in", values, "zgzt");
            return (Criteria) this;
        }

        public Criteria andZgztNotIn(List<String> values) {
            addCriterion("ZGZT not in", values, "zgzt");
            return (Criteria) this;
        }

        public Criteria andZgztBetween(String value1, String value2) {
            addCriterion("ZGZT between", value1, value2, "zgzt");
            return (Criteria) this;
        }

        public Criteria andZgztNotBetween(String value1, String value2) {
            addCriterion("ZGZT not between", value1, value2, "zgzt");
            return (Criteria) this;
        }

        public Criteria andIsshIsNull() {
            addCriterion("ISSH is null");
            return (Criteria) this;
        }

        public Criteria andIsshIsNotNull() {
            addCriterion("ISSH is not null");
            return (Criteria) this;
        }

        public Criteria andIsshEqualTo(String value) {
            addCriterion("ISSH =", value, "issh");
            return (Criteria) this;
        }

        public Criteria andIsshNotEqualTo(String value) {
            addCriterion("ISSH <>", value, "issh");
            return (Criteria) this;
        }

        public Criteria andIsshGreaterThan(String value) {
            addCriterion("ISSH >", value, "issh");
            return (Criteria) this;
        }

        public Criteria andIsshGreaterThanOrEqualTo(String value) {
            addCriterion("ISSH >=", value, "issh");
            return (Criteria) this;
        }

        public Criteria andIsshLessThan(String value) {
            addCriterion("ISSH <", value, "issh");
            return (Criteria) this;
        }

        public Criteria andIsshLessThanOrEqualTo(String value) {
            addCriterion("ISSH <=", value, "issh");
            return (Criteria) this;
        }

        public Criteria andIsshLike(String value) {
            addCriterion("ISSH like", value, "issh");
            return (Criteria) this;
        }

        public Criteria andIsshNotLike(String value) {
            addCriterion("ISSH not like", value, "issh");
            return (Criteria) this;
        }

        public Criteria andIsshIn(List<String> values) {
            addCriterion("ISSH in", values, "issh");
            return (Criteria) this;
        }

        public Criteria andIsshNotIn(List<String> values) {
            addCriterion("ISSH not in", values, "issh");
            return (Criteria) this;
        }

        public Criteria andIsshBetween(String value1, String value2) {
            addCriterion("ISSH between", value1, value2, "issh");
            return (Criteria) this;
        }

        public Criteria andIsshNotBetween(String value1, String value2) {
            addCriterion("ISSH not between", value1, value2, "issh");
            return (Criteria) this;
        }

        public Criteria andWtgyyIsNull() {
            addCriterion("WTGYY is null");
            return (Criteria) this;
        }

        public Criteria andWtgyyIsNotNull() {
            addCriterion("WTGYY is not null");
            return (Criteria) this;
        }

        public Criteria andWtgyyEqualTo(String value) {
            addCriterion("WTGYY =", value, "wtgyy");
            return (Criteria) this;
        }

        public Criteria andWtgyyNotEqualTo(String value) {
            addCriterion("WTGYY <>", value, "wtgyy");
            return (Criteria) this;
        }

        public Criteria andWtgyyGreaterThan(String value) {
            addCriterion("WTGYY >", value, "wtgyy");
            return (Criteria) this;
        }

        public Criteria andWtgyyGreaterThanOrEqualTo(String value) {
            addCriterion("WTGYY >=", value, "wtgyy");
            return (Criteria) this;
        }

        public Criteria andWtgyyLessThan(String value) {
            addCriterion("WTGYY <", value, "wtgyy");
            return (Criteria) this;
        }

        public Criteria andWtgyyLessThanOrEqualTo(String value) {
            addCriterion("WTGYY <=", value, "wtgyy");
            return (Criteria) this;
        }

        public Criteria andWtgyyLike(String value) {
            addCriterion("WTGYY like", value, "wtgyy");
            return (Criteria) this;
        }

        public Criteria andWtgyyNotLike(String value) {
            addCriterion("WTGYY not like", value, "wtgyy");
            return (Criteria) this;
        }

        public Criteria andWtgyyIn(List<String> values) {
            addCriterion("WTGYY in", values, "wtgyy");
            return (Criteria) this;
        }

        public Criteria andWtgyyNotIn(List<String> values) {
            addCriterion("WTGYY not in", values, "wtgyy");
            return (Criteria) this;
        }

        public Criteria andWtgyyBetween(String value1, String value2) {
            addCriterion("WTGYY between", value1, value2, "wtgyy");
            return (Criteria) this;
        }

        public Criteria andWtgyyNotBetween(String value1, String value2) {
            addCriterion("WTGYY not between", value1, value2, "wtgyy");
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