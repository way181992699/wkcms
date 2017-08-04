package org.wkidt.wkcms.article.mapper;

import org.wkidt.wkcms.article.model.DocCatagory;

public interface DocCatagoryMapper {
    int deleteByPrimaryKey(Long catagoryId);

    int insert(DocCatagory record);

    int insertSelective(DocCatagory record);

    DocCatagory selectByPrimaryKey(Long catagoryId);

    int updateByPrimaryKeySelective(DocCatagory record);

    int updateByPrimaryKey(DocCatagory record);
}