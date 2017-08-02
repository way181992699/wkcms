package org.wkidt.wkcms.article.mapper;

import org.wkidt.wkcms.article.model.Article;
import org.wkidt.wkcms.article.model.ArticleWithBLOBs;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    ArticleWithBLOBs selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);
}