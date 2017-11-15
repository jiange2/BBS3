package com.gdut.bbs.domain;

import java.util.Date;

public class Comment {
    private Integer cid;

    private Integer rid;

    private Integer pid;

    private Integer commentUid;

    private String commentUnickname;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCommentUid() {
        return commentUid;
    }

    public void setCommentUid(Integer commentUid) {
        this.commentUid = commentUid;
    }

    public String getCommentUnickname() {
        return commentUnickname;
    }

    public void setCommentUnickname(String commentUnickname) {
        this.commentUnickname = commentUnickname == null ? null : commentUnickname.trim();
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