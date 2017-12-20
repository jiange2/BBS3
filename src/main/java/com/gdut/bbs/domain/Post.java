package com.gdut.bbs.domain;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;
public class Post {
    private Integer pid;
    private Integer uid;
    private String unickname;
    private String uavatar;
    @NotNull
    @Length(min = 5,max = 30)
    private String title;
    @NotNull
    private String content;
    private Date postTime;
    private Date lastReplyTime;
    private Integer replyCount;
    private Integer starCount;
    private Integer watchCount;
    public void init(){
        replyCount = 0;
        starCount = 0;
        watchCount = 0;
        Date now = new Date();
        lastReplyTime = now;
        postTime = now;
        pid = null;
    }
    public String getUavatar() {
        return uavatar;
    }
    public void setUavatar(String uavatar) {
        this.uavatar = uavatar;
    }
    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getUnickname() {
        return unickname;
    }
    public void setUnickname(String unickname) {
        this.unickname = unickname == null ? null : unickname.trim();
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    public Date getPostTime() {
        return postTime;
    }
    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }
    public Date getLastReplyTime() {
        return lastReplyTime;
    }
    public void setLastReplyTime(Date lastReplyTime) {
        this.lastReplyTime = lastReplyTime;
    }
    public Integer getReplyCount() {
        return replyCount;
    }
    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }
    public Integer getStarCount() {
        return starCount;
    }
    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }
    public Integer getWatchCount() {
        return watchCount;
    }
    public void setWatchCount(Integer watchCount) {
        this.watchCount = watchCount;
    }
}