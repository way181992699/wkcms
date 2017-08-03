package org.wkidt.wkcms.user.model;


import java.util.Date;
import java.util.List;

public class User {
    private Long userId;

    private String userName;

    private String password;

    private Integer sex;

    private Date birthday;

    private Date createTime;

    private Date lastUpdaetTime;

    private List<Role> roles;


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdaetTime() {
        return lastUpdaetTime;
    }

    public void setLastUpdaetTime(Date lastUpdaetTime) {
        this.lastUpdaetTime = lastUpdaetTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                ", lastUpdaetTime=" + lastUpdaetTime +
                ", roles=" + roles +
                '}';
    }


}
