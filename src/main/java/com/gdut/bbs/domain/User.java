package com.gdut.bbs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class User {
    @Null(groups = {Register.class})
    private Integer userid;
    @NotNull(message = "{user.username.notNull}",
            groups = {Register.class,Login.class})
    @Length(min = 9,max = 20,
            groups = {Register.class,Login.class},
            message = "{user.username.length}")
    @Pattern(regexp = "[A-Za-z]+[A-Za-z\\d]+",
            groups = {Register.class,Login.class},
            message = "{user.username.regexp}")
    private String username;
    @NotNull(message = "{user.password.notNull}",
            groups = {Register.class,Login.class})
    @Length(min = 6,max = 50,
            groups = {Register.class,Login.class},
            message = "{user.password.length}")
    @Pattern(regexp = "[A-Za-z0-9.]+",
            groups = {Register.class,Login.class},
            message = "{user.password.regexp}")
    @JsonIgnore
    private String password;
    @Null(groups = {Register.class})
    private String nickname;

    @Email(message = "{user.email}",
            groups = {Register.class,GetRegisterCode.class})
    @NotNull(message = "{user.email.notNull}",
            groups = {Register.class,GetRegisterCode.class})
    @Length(min = 1,
            groups = {Register.class,GetRegisterCode.class},
            message = "{user.username.notNull}")
    private String email;

    @Null(groups = {Register.class})
    private Integer follow;
    @Null(groups = {Register.class})
    private Date regDate;
    @Null(groups = {Register.class})
    private String gender;
    @Null(groups = {Register.class})
    private Date birthday;
    @Null(groups = {Register.class})
    private String avatar;
    @Null(groups = {Register.class})
    private String statement;
    @Null(groups = {Register.class})
    private Integer point;
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    public Integer getFollow() {
        return follow;
    }
    public void setFollow(Integer follow) {
        this.follow = follow;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }
    public String getStatement() {
        return statement;
    }
    public void setStatement(String statement) {
        this.statement = statement == null ? null : statement.trim();
    }
    public Integer getPoint() {
        return point;
    }
    public void setPoint(Integer point) {
        this.point = point;
    }
    public interface Register {}
    public interface Login{}
    public interface GetRegisterCode{}
}