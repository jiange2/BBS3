package com.gdut.bbs.domain;

import java.util.Date;

public class Comment {
    private Integer cid;

    private Integer rid;

    private Integer uid;

    private Integer unickname;

    private String content;

    private Date commentTime;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUnickname() {
        return unickname;
    }

    public void setUnickname(Integer unickname) {
        this.unickname = unickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}