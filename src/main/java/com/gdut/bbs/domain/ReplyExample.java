package com.gdut.bbs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReplyExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andUavatarIsNull() {
            addCriterion("uavatar is null");
            return (Criteria) this;
        }

        public Criteria andUavatarIsNotNull() {
            addCriterion("uavatar is not null");
            return (Criteria) this;
        }

        public Criteria andUavatarEqualTo(String value) {
            addCriterion("uavatar =", value, "uavatar");
            return (Criteria) this;
        }

        public Criteria andUavatarNotEqualTo(String value) {
            addCriterion("uavatar <>", value, "uavatar");
            return (Criteria) this;
        }

        public Criteria andUavatarGreaterThan(String value) {
            addCriterion("uavatar >", value, "uavatar");
            return (Criteria) this;
        }

        public Criteria andUavatarGreaterThanOrEqualTo(String value) {
            addCriterion("uavatar >=", value, "uavatar");
            return (Criteria) this;
        }

        public Criteria andUavatarLessThan(String value) {
            addCriterion("uavatar <", value, "uavatar");
            return (Criteria) this;
        }

        public Criteria andUavatarLessThanOrEqualTo(String value) {
            addCriterion("uavatar <=", value, "uavatar");
            return (Criteria) this;
        }

        public Criteria andUavatarLike(String value) {
            addCriterion("uavatar like", value, "uavatar");
            return (Criteria) this;
        }

        public Criteria andUavatarNotLike(String value) {
            addCriterion("uavatar not like", value, "uavatar");
            return (Criteria) this;
        }

        public Criteria andUavatarIn(List<String> values) {
            addCriterion("uavatar in", values, "uavatar");
            return (Criteria) this;
        }

        public Criteria andUavatarNotIn(List<String> values) {
            addCriterion("uavatar not in", values, "uavatar");
            return (Criteria) this;
        }

        public Criteria andUavatarBetween(String value1, String value2) {
            addCriterion("uavatar between", value1, value2, "uavatar");
            return (Criteria) this;
        }

        public Criteria andUavatarNotBetween(String value1, String value2) {
            addCriterion("uavatar not between", value1, value2, "uavatar");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUnicknameIsNull() {
            addCriterion("unickname is null");
            return (Criteria) this;
        }

        public Criteria andUnicknameIsNotNull() {
            addCriterion("unickname is not null");
            return (Criteria) this;
        }

        public Criteria andUnicknameEqualTo(String value) {
            addCriterion("unickname =", value, "unickname");
            return (Criteria) this;
        }

        public Criteria andUnicknameNotEqualTo(String value) {
            addCriterion("unickname <>", value, "unickname");
            return (Criteria) this;
        }

        public Criteria andUnicknameGreaterThan(String value) {
            addCriterion("unickname >", value, "unickname");
            return (Criteria) this;
        }

        public Criteria andUnicknameGreaterThanOrEqualTo(String value) {
            addCriterion("unickname >=", value, "unickname");
            return (Criteria) this;
        }

        public Criteria andUnicknameLessThan(String value) {
            addCriterion("unickname <", value, "unickname");
            return (Criteria) this;
        }

        public Criteria andUnicknameLessThanOrEqualTo(String value) {
            addCriterion("unickname <=", value, "unickname");
            return (Criteria) this;
        }

        public Criteria andUnicknameLike(String value) {
            addCriterion("unickname like", value, "unickname");
            return (Criteria) this;
        }

        public Criteria andUnicknameNotLike(String value) {
            addCriterion("unickname not like", value, "unickname");
            return (Criteria) this;
        }

        public Criteria andUnicknameIn(List<String> values) {
            addCriterion("unickname in", values, "unickname");
            return (Criteria) this;
        }

        public Criteria andUnicknameNotIn(List<String> values) {
            addCriterion("unickname not in", values, "unickname");
            return (Criteria) this;
        }

        public Criteria andUnicknameBetween(String value1, String value2) {
            addCriterion("unickname between", value1, value2, "unickname");
            return (Criteria) this;
        }

        public Criteria andUnicknameNotBetween(String value1, String value2) {
            addCriterion("unickname not between", value1, value2, "unickname");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNull() {
            addCriterion("reply_time is null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNotNull() {
            addCriterion("reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeEqualTo(Date value) {
            addCriterion("reply_time =", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotEqualTo(Date value) {
            addCriterion("reply_time <>", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThan(Date value) {
            addCriterion("reply_time >", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_time >=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThan(Date value) {
            addCriterion("reply_time <", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_time <=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIn(List<Date> values) {
            addCriterion("reply_time in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotIn(List<Date> values) {
            addCriterion("reply_time not in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeBetween(Date value1, Date value2) {
            addCriterion("reply_time between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_time not between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andAgreeCountIsNull() {
            addCriterion("agree_count is null");
            return (Criteria) this;
        }

        public Criteria andAgreeCountIsNotNull() {
            addCriterion("agree_count is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeCountEqualTo(Integer value) {
            addCriterion("agree_count =", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountNotEqualTo(Integer value) {
            addCriterion("agree_count <>", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountGreaterThan(Integer value) {
            addCriterion("agree_count >", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("agree_count >=", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountLessThan(Integer value) {
            addCriterion("agree_count <", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountLessThanOrEqualTo(Integer value) {
            addCriterion("agree_count <=", value, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountIn(List<Integer> values) {
            addCriterion("agree_count in", values, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountNotIn(List<Integer> values) {
            addCriterion("agree_count not in", values, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountBetween(Integer value1, Integer value2) {
            addCriterion("agree_count between", value1, value2, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andAgreeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("agree_count not between", value1, value2, "agreeCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
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