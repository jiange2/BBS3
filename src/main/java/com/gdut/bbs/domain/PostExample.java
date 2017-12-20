package com.gdut.bbs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PostExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNull() {
            addCriterion("post_time is null");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNotNull() {
            addCriterion("post_time is not null");
            return (Criteria) this;
        }

        public Criteria andPostTimeEqualTo(Date value) {
            addCriterion("post_time =", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotEqualTo(Date value) {
            addCriterion("post_time <>", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThan(Date value) {
            addCriterion("post_time >", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("post_time >=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThan(Date value) {
            addCriterion("post_time <", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThanOrEqualTo(Date value) {
            addCriterion("post_time <=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeIn(List<Date> values) {
            addCriterion("post_time in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotIn(List<Date> values) {
            addCriterion("post_time not in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeBetween(Date value1, Date value2) {
            addCriterion("post_time between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotBetween(Date value1, Date value2) {
            addCriterion("post_time not between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeIsNull() {
            addCriterion("last_reply_time is null");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeIsNotNull() {
            addCriterion("last_reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeEqualTo(Date value) {
            addCriterion("last_reply_time =", value, "lastReplyTime");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeNotEqualTo(Date value) {
            addCriterion("last_reply_time <>", value, "lastReplyTime");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeGreaterThan(Date value) {
            addCriterion("last_reply_time >", value, "lastReplyTime");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_reply_time >=", value, "lastReplyTime");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeLessThan(Date value) {
            addCriterion("last_reply_time <", value, "lastReplyTime");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_reply_time <=", value, "lastReplyTime");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeIn(List<Date> values) {
            addCriterion("last_reply_time in", values, "lastReplyTime");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeNotIn(List<Date> values) {
            addCriterion("last_reply_time not in", values, "lastReplyTime");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeBetween(Date value1, Date value2) {
            addCriterion("last_reply_time between", value1, value2, "lastReplyTime");
            return (Criteria) this;
        }

        public Criteria andLastReplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_reply_time not between", value1, value2, "lastReplyTime");
            return (Criteria) this;
        }

        public Criteria andReplyCountIsNull() {
            addCriterion("reply_count is null");
            return (Criteria) this;
        }

        public Criteria andReplyCountIsNotNull() {
            addCriterion("reply_count is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCountEqualTo(Integer value) {
            addCriterion("reply_count =", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotEqualTo(Integer value) {
            addCriterion("reply_count <>", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThan(Integer value) {
            addCriterion("reply_count >", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_count >=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThan(Integer value) {
            addCriterion("reply_count <", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("reply_count <=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountIn(List<Integer> values) {
            addCriterion("reply_count in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotIn(List<Integer> values) {
            addCriterion("reply_count not in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountBetween(Integer value1, Integer value2) {
            addCriterion("reply_count between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_count not between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andStarCountIsNull() {
            addCriterion("star_count is null");
            return (Criteria) this;
        }

        public Criteria andStarCountIsNotNull() {
            addCriterion("star_count is not null");
            return (Criteria) this;
        }

        public Criteria andStarCountEqualTo(Integer value) {
            addCriterion("star_count =", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountNotEqualTo(Integer value) {
            addCriterion("star_count <>", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountGreaterThan(Integer value) {
            addCriterion("star_count >", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("star_count >=", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountLessThan(Integer value) {
            addCriterion("star_count <", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountLessThanOrEqualTo(Integer value) {
            addCriterion("star_count <=", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountIn(List<Integer> values) {
            addCriterion("star_count in", values, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountNotIn(List<Integer> values) {
            addCriterion("star_count not in", values, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountBetween(Integer value1, Integer value2) {
            addCriterion("star_count between", value1, value2, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountNotBetween(Integer value1, Integer value2) {
            addCriterion("star_count not between", value1, value2, "starCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountIsNull() {
            addCriterion("watch_count is null");
            return (Criteria) this;
        }

        public Criteria andWatchCountIsNotNull() {
            addCriterion("watch_count is not null");
            return (Criteria) this;
        }

        public Criteria andWatchCountEqualTo(Integer value) {
            addCriterion("watch_count =", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountNotEqualTo(Integer value) {
            addCriterion("watch_count <>", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountGreaterThan(Integer value) {
            addCriterion("watch_count >", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("watch_count >=", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountLessThan(Integer value) {
            addCriterion("watch_count <", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountLessThanOrEqualTo(Integer value) {
            addCriterion("watch_count <=", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountIn(List<Integer> values) {
            addCriterion("watch_count in", values, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountNotIn(List<Integer> values) {
            addCriterion("watch_count not in", values, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountBetween(Integer value1, Integer value2) {
            addCriterion("watch_count between", value1, value2, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountNotBetween(Integer value1, Integer value2) {
            addCriterion("watch_count not between", value1, value2, "watchCount");
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