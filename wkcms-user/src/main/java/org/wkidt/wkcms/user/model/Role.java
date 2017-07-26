package org.wkidt.wkcms.user.model;

import java.util.Date;

public class Role {
    private Long roleId;

    private String roleName;

    private Long createUid;

    private Date createTime;

    private Long modifyUid;

    private Date modifyTime;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifyUid() {
        return modifyUid;
    }

    public void setModifyUid(Long modifyUid) {
        this.modifyUid = modifyUid;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}