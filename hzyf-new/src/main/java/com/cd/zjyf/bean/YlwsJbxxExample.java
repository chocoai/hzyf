package com.cd.zjyf.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YlwsJbxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YlwsJbxxExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShyxdmIsNull() {
            addCriterion("shyxdm is null");
            return (Criteria) this;
        }

        public Criteria andShyxdmIsNotNull() {
            addCriterion("shyxdm is not null");
            return (Criteria) this;
        }

        public Criteria andShyxdmEqualTo(String value) {
            addCriterion("shyxdm =", value, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andShyxdmNotEqualTo(String value) {
            addCriterion("shyxdm <>", value, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andShyxdmGreaterThan(String value) {
            addCriterion("shyxdm >", value, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andShyxdmGreaterThanOrEqualTo(String value) {
            addCriterion("shyxdm >=", value, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andShyxdmLessThan(String value) {
            addCriterion("shyxdm <", value, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andShyxdmLessThanOrEqualTo(String value) {
            addCriterion("shyxdm <=", value, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andShyxdmLike(String value) {
            addCriterion("shyxdm like", value, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andShyxdmNotLike(String value) {
            addCriterion("shyxdm not like", value, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andShyxdmIn(List<String> values) {
            addCriterion("shyxdm in", values, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andShyxdmNotIn(List<String> values) {
            addCriterion("shyxdm not in", values, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andShyxdmBetween(String value1, String value2) {
            addCriterion("shyxdm between", value1, value2, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andShyxdmNotBetween(String value1, String value2) {
            addCriterion("shyxdm not between", value1, value2, "shyxdm");
            return (Criteria) this;
        }

        public Criteria andYljgtypeIsNull() {
            addCriterion("yljgtype is null");
            return (Criteria) this;
        }

        public Criteria andYljgtypeIsNotNull() {
            addCriterion("yljgtype is not null");
            return (Criteria) this;
        }

        public Criteria andYljgtypeEqualTo(Short value) {
            addCriterion("yljgtype =", value, "yljgtype");
            return (Criteria) this;
        }

        public Criteria andYljgtypeNotEqualTo(Short value) {
            addCriterion("yljgtype <>", value, "yljgtype");
            return (Criteria) this;
        }

        public Criteria andYljgtypeGreaterThan(Short value) {
            addCriterion("yljgtype >", value, "yljgtype");
            return (Criteria) this;
        }

        public Criteria andYljgtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("yljgtype >=", value, "yljgtype");
            return (Criteria) this;
        }

        public Criteria andYljgtypeLessThan(Short value) {
            addCriterion("yljgtype <", value, "yljgtype");
            return (Criteria) this;
        }

        public Criteria andYljgtypeLessThanOrEqualTo(Short value) {
            addCriterion("yljgtype <=", value, "yljgtype");
            return (Criteria) this;
        }

        public Criteria andYljgtypeIn(List<Short> values) {
            addCriterion("yljgtype in", values, "yljgtype");
            return (Criteria) this;
        }

        public Criteria andYljgtypeNotIn(List<Short> values) {
            addCriterion("yljgtype not in", values, "yljgtype");
            return (Criteria) this;
        }

        public Criteria andYljgtypeBetween(Short value1, Short value2) {
            addCriterion("yljgtype between", value1, value2, "yljgtype");
            return (Criteria) this;
        }

        public Criteria andYljgtypeNotBetween(Short value1, Short value2) {
            addCriterion("yljgtype not between", value1, value2, "yljgtype");
            return (Criteria) this;
        }

        public Criteria andDwmcIsNull() {
            addCriterion("dwmc is null");
            return (Criteria) this;
        }

        public Criteria andDwmcIsNotNull() {
            addCriterion("dwmc is not null");
            return (Criteria) this;
        }

        public Criteria andDwmcEqualTo(String value) {
            addCriterion("dwmc =", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcNotEqualTo(String value) {
            addCriterion("dwmc <>", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcGreaterThan(String value) {
            addCriterion("dwmc >", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcGreaterThanOrEqualTo(String value) {
            addCriterion("dwmc >=", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcLessThan(String value) {
            addCriterion("dwmc <", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcLessThanOrEqualTo(String value) {
            addCriterion("dwmc <=", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcLike(String value) {
            addCriterion("dwmc like", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcNotLike(String value) {
            addCriterion("dwmc not like", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcIn(List<String> values) {
            addCriterion("dwmc in", values, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcNotIn(List<String> values) {
            addCriterion("dwmc not in", values, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcBetween(String value1, String value2) {
            addCriterion("dwmc between", value1, value2, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcNotBetween(String value1, String value2) {
            addCriterion("dwmc not between", value1, value2, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwjcIsNull() {
            addCriterion("dwjc is null");
            return (Criteria) this;
        }

        public Criteria andDwjcIsNotNull() {
            addCriterion("dwjc is not null");
            return (Criteria) this;
        }

        public Criteria andDwjcEqualTo(String value) {
            addCriterion("dwjc =", value, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwjcNotEqualTo(String value) {
            addCriterion("dwjc <>", value, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwjcGreaterThan(String value) {
            addCriterion("dwjc >", value, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwjcGreaterThanOrEqualTo(String value) {
            addCriterion("dwjc >=", value, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwjcLessThan(String value) {
            addCriterion("dwjc <", value, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwjcLessThanOrEqualTo(String value) {
            addCriterion("dwjc <=", value, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwjcLike(String value) {
            addCriterion("dwjc like", value, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwjcNotLike(String value) {
            addCriterion("dwjc not like", value, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwjcIn(List<String> values) {
            addCriterion("dwjc in", values, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwjcNotIn(List<String> values) {
            addCriterion("dwjc not in", values, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwjcBetween(String value1, String value2) {
            addCriterion("dwjc between", value1, value2, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwjcNotBetween(String value1, String value2) {
            addCriterion("dwjc not between", value1, value2, "dwjc");
            return (Criteria) this;
        }

        public Criteria andDwdzIsNull() {
            addCriterion("dwdz is null");
            return (Criteria) this;
        }

        public Criteria andDwdzIsNotNull() {
            addCriterion("dwdz is not null");
            return (Criteria) this;
        }

        public Criteria andDwdzEqualTo(String value) {
            addCriterion("dwdz =", value, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzNotEqualTo(String value) {
            addCriterion("dwdz <>", value, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzGreaterThan(String value) {
            addCriterion("dwdz >", value, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzGreaterThanOrEqualTo(String value) {
            addCriterion("dwdz >=", value, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzLessThan(String value) {
            addCriterion("dwdz <", value, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzLessThanOrEqualTo(String value) {
            addCriterion("dwdz <=", value, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzLike(String value) {
            addCriterion("dwdz like", value, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzNotLike(String value) {
            addCriterion("dwdz not like", value, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzIn(List<String> values) {
            addCriterion("dwdz in", values, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzNotIn(List<String> values) {
            addCriterion("dwdz not in", values, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzBetween(String value1, String value2) {
            addCriterion("dwdz between", value1, value2, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzNotBetween(String value1, String value2) {
            addCriterion("dwdz not between", value1, value2, "dwdz");
            return (Criteria) this;
        }

        public Criteria andDwdzbmIsNull() {
            addCriterion("dwdzbm is null");
            return (Criteria) this;
        }

        public Criteria andDwdzbmIsNotNull() {
            addCriterion("dwdzbm is not null");
            return (Criteria) this;
        }

        public Criteria andDwdzbmEqualTo(String value) {
            addCriterion("dwdzbm =", value, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andDwdzbmNotEqualTo(String value) {
            addCriterion("dwdzbm <>", value, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andDwdzbmGreaterThan(String value) {
            addCriterion("dwdzbm >", value, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andDwdzbmGreaterThanOrEqualTo(String value) {
            addCriterion("dwdzbm >=", value, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andDwdzbmLessThan(String value) {
            addCriterion("dwdzbm <", value, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andDwdzbmLessThanOrEqualTo(String value) {
            addCriterion("dwdzbm <=", value, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andDwdzbmLike(String value) {
            addCriterion("dwdzbm like", value, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andDwdzbmNotLike(String value) {
            addCriterion("dwdzbm not like", value, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andDwdzbmIn(List<String> values) {
            addCriterion("dwdzbm in", values, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andDwdzbmNotIn(List<String> values) {
            addCriterion("dwdzbm not in", values, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andDwdzbmBetween(String value1, String value2) {
            addCriterion("dwdzbm between", value1, value2, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andDwdzbmNotBetween(String value1, String value2) {
            addCriterion("dwdzbm not between", value1, value2, "dwdzbm");
            return (Criteria) this;
        }

        public Criteria andZcdidIsNull() {
            addCriterion("zcdid is null");
            return (Criteria) this;
        }

        public Criteria andZcdidIsNotNull() {
            addCriterion("zcdid is not null");
            return (Criteria) this;
        }

        public Criteria andZcdidEqualTo(String value) {
            addCriterion("zcdid =", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidNotEqualTo(String value) {
            addCriterion("zcdid <>", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidGreaterThan(String value) {
            addCriterion("zcdid >", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidGreaterThanOrEqualTo(String value) {
            addCriterion("zcdid >=", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidLessThan(String value) {
            addCriterion("zcdid <", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidLessThanOrEqualTo(String value) {
            addCriterion("zcdid <=", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidLike(String value) {
            addCriterion("zcdid like", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidNotLike(String value) {
            addCriterion("zcdid not like", value, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidIn(List<String> values) {
            addCriterion("zcdid in", values, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidNotIn(List<String> values) {
            addCriterion("zcdid not in", values, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidBetween(String value1, String value2) {
            addCriterion("zcdid between", value1, value2, "zcdid");
            return (Criteria) this;
        }

        public Criteria andZcdidNotBetween(String value1, String value2) {
            addCriterion("zcdid not between", value1, value2, "zcdid");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNull() {
            addCriterion("qrcode is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNotNull() {
            addCriterion("qrcode is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeEqualTo(String value) {
            addCriterion("qrcode =", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotEqualTo(String value) {
            addCriterion("qrcode <>", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThan(String value) {
            addCriterion("qrcode >", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("qrcode >=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThan(String value) {
            addCriterion("qrcode <", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThanOrEqualTo(String value) {
            addCriterion("qrcode <=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLike(String value) {
            addCriterion("qrcode like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotLike(String value) {
            addCriterion("qrcode not like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeIn(List<String> values) {
            addCriterion("qrcode in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotIn(List<String> values) {
            addCriterion("qrcode not in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeBetween(String value1, String value2) {
            addCriterion("qrcode between", value1, value2, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotBetween(String value1, String value2) {
            addCriterion("qrcode not between", value1, value2, "qrcode");
            return (Criteria) this;
        }

        public Criteria andYyztIsNull() {
            addCriterion("yyzt is null");
            return (Criteria) this;
        }

        public Criteria andYyztIsNotNull() {
            addCriterion("yyzt is not null");
            return (Criteria) this;
        }

        public Criteria andYyztEqualTo(String value) {
            addCriterion("yyzt =", value, "yyzt");
            return (Criteria) this;
        }

        public Criteria andYyztNotEqualTo(String value) {
            addCriterion("yyzt <>", value, "yyzt");
            return (Criteria) this;
        }

        public Criteria andYyztGreaterThan(String value) {
            addCriterion("yyzt >", value, "yyzt");
            return (Criteria) this;
        }

        public Criteria andYyztGreaterThanOrEqualTo(String value) {
            addCriterion("yyzt >=", value, "yyzt");
            return (Criteria) this;
        }

        public Criteria andYyztLessThan(String value) {
            addCriterion("yyzt <", value, "yyzt");
            return (Criteria) this;
        }

        public Criteria andYyztLessThanOrEqualTo(String value) {
            addCriterion("yyzt <=", value, "yyzt");
            return (Criteria) this;
        }

        public Criteria andYyztLike(String value) {
            addCriterion("yyzt like", value, "yyzt");
            return (Criteria) this;
        }

        public Criteria andYyztNotLike(String value) {
            addCriterion("yyzt not like", value, "yyzt");
            return (Criteria) this;
        }

        public Criteria andYyztIn(List<String> values) {
            addCriterion("yyzt in", values, "yyzt");
            return (Criteria) this;
        }

        public Criteria andYyztNotIn(List<String> values) {
            addCriterion("yyzt not in", values, "yyzt");
            return (Criteria) this;
        }

        public Criteria andYyztBetween(String value1, String value2) {
            addCriterion("yyzt between", value1, value2, "yyzt");
            return (Criteria) this;
        }

        public Criteria andYyztNotBetween(String value1, String value2) {
            addCriterion("yyzt not between", value1, value2, "yyzt");
            return (Criteria) this;
        }

        public Criteria andDjridIsNull() {
            addCriterion("djrid is null");
            return (Criteria) this;
        }

        public Criteria andDjridIsNotNull() {
            addCriterion("djrid is not null");
            return (Criteria) this;
        }

        public Criteria andDjridEqualTo(String value) {
            addCriterion("djrid =", value, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjridNotEqualTo(String value) {
            addCriterion("djrid <>", value, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjridGreaterThan(String value) {
            addCriterion("djrid >", value, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjridGreaterThanOrEqualTo(String value) {
            addCriterion("djrid >=", value, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjridLessThan(String value) {
            addCriterion("djrid <", value, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjridLessThanOrEqualTo(String value) {
            addCriterion("djrid <=", value, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjridLike(String value) {
            addCriterion("djrid like", value, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjridNotLike(String value) {
            addCriterion("djrid not like", value, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjridIn(List<String> values) {
            addCriterion("djrid in", values, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjridNotIn(List<String> values) {
            addCriterion("djrid not in", values, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjridBetween(String value1, String value2) {
            addCriterion("djrid between", value1, value2, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjridNotBetween(String value1, String value2) {
            addCriterion("djrid not between", value1, value2, "djrid");
            return (Criteria) this;
        }

        public Criteria andDjsjIsNull() {
            addCriterion("djsj is null");
            return (Criteria) this;
        }

        public Criteria andDjsjIsNotNull() {
            addCriterion("djsj is not null");
            return (Criteria) this;
        }

        public Criteria andDjsjEqualTo(Date value) {
            addCriterion("djsj =", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjNotEqualTo(Date value) {
            addCriterion("djsj <>", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjGreaterThan(Date value) {
            addCriterion("djsj >", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjGreaterThanOrEqualTo(Date value) {
            addCriterion("djsj >=", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjLessThan(Date value) {
            addCriterion("djsj <", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjLessThanOrEqualTo(Date value) {
            addCriterion("djsj <=", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjIn(List<Date> values) {
            addCriterion("djsj in", values, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjNotIn(List<Date> values) {
            addCriterion("djsj not in", values, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjBetween(Date value1, Date value2) {
            addCriterion("djsj between", value1, value2, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjNotBetween(Date value1, Date value2) {
            addCriterion("djsj not between", value1, value2, "djsj");
            return (Criteria) this;
        }

        public Criteria andJgdwidIsNull() {
            addCriterion("jgdwid is null");
            return (Criteria) this;
        }

        public Criteria andJgdwidIsNotNull() {
            addCriterion("jgdwid is not null");
            return (Criteria) this;
        }

        public Criteria andJgdwidEqualTo(String value) {
            addCriterion("jgdwid =", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidNotEqualTo(String value) {
            addCriterion("jgdwid <>", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidGreaterThan(String value) {
            addCriterion("jgdwid >", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidGreaterThanOrEqualTo(String value) {
            addCriterion("jgdwid >=", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidLessThan(String value) {
            addCriterion("jgdwid <", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidLessThanOrEqualTo(String value) {
            addCriterion("jgdwid <=", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidLike(String value) {
            addCriterion("jgdwid like", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidNotLike(String value) {
            addCriterion("jgdwid not like", value, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidIn(List<String> values) {
            addCriterion("jgdwid in", values, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidNotIn(List<String> values) {
            addCriterion("jgdwid not in", values, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidBetween(String value1, String value2) {
            addCriterion("jgdwid between", value1, value2, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andJgdwidNotBetween(String value1, String value2) {
            addCriterion("jgdwid not between", value1, value2, "jgdwid");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(String value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(String value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(String value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(String value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(String value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(String value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLike(String value) {
            addCriterion("isdelete like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotLike(String value) {
            addCriterion("isdelete not like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<String> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<String> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(String value1, String value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(String value1, String value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsSewageIsNull() {
            addCriterion("is_sewage is null");
            return (Criteria) this;
        }

        public Criteria andIsSewageIsNotNull() {
            addCriterion("is_sewage is not null");
            return (Criteria) this;
        }

        public Criteria andIsSewageEqualTo(String value) {
            addCriterion("is_sewage =", value, "isSewage");
            return (Criteria) this;
        }

        public Criteria andIsSewageNotEqualTo(String value) {
            addCriterion("is_sewage <>", value, "isSewage");
            return (Criteria) this;
        }

        public Criteria andIsSewageGreaterThan(String value) {
            addCriterion("is_sewage >", value, "isSewage");
            return (Criteria) this;
        }

        public Criteria andIsSewageGreaterThanOrEqualTo(String value) {
            addCriterion("is_sewage >=", value, "isSewage");
            return (Criteria) this;
        }

        public Criteria andIsSewageLessThan(String value) {
            addCriterion("is_sewage <", value, "isSewage");
            return (Criteria) this;
        }

        public Criteria andIsSewageLessThanOrEqualTo(String value) {
            addCriterion("is_sewage <=", value, "isSewage");
            return (Criteria) this;
        }

        public Criteria andIsSewageLike(String value) {
            addCriterion("is_sewage like", value, "isSewage");
            return (Criteria) this;
        }

        public Criteria andIsSewageNotLike(String value) {
            addCriterion("is_sewage not like", value, "isSewage");
            return (Criteria) this;
        }

        public Criteria andIsSewageIn(List<String> values) {
            addCriterion("is_sewage in", values, "isSewage");
            return (Criteria) this;
        }

        public Criteria andIsSewageNotIn(List<String> values) {
            addCriterion("is_sewage not in", values, "isSewage");
            return (Criteria) this;
        }

        public Criteria andIsSewageBetween(String value1, String value2) {
            addCriterion("is_sewage between", value1, value2, "isSewage");
            return (Criteria) this;
        }

        public Criteria andIsSewageNotBetween(String value1, String value2) {
            addCriterion("is_sewage not between", value1, value2, "isSewage");
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