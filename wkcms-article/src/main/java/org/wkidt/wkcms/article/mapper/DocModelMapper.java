package org.wkidt.wkcms.article.mapper;

import org.wkidt.wkcms.article.model.DocModel;

public interface DocModelMapper {
    int deleteByPrimaryKey(Long modelId);

    int insert(DocModel record);

    int insertSelective(DocModel record);

    DocModel selectByPrimaryKey(Long modelId);

    int updateByPrimaryKeySelective(DocModel record);

    int updateByPrimaryKey(DocModel record);
}