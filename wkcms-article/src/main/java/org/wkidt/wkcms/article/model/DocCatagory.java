package org.wkidt.wkcms.article.model;

public class DocCatagory {
    private Long catagoryId;

    private Long parentId;

    private String catagoryName;

    public Long getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Long catagoryId) {
        this.catagoryId = catagoryId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName == null ? null : catagoryName.trim();
    }
}