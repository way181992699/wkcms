package org.wkidt.wkcms.article.mapper;

import org.wkidt.wkcms.article.model.Article;
import org.wkidt.wkcms.article.model.ArticleWithBLOBs;
import org.wkidt.wkcms.common.PageForm;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);

    /**
     * 获取记录数
     *
     * @return
     */
    long getCount();


    ArticleWithBLOBs selectByPrimaryKey(Long articleId);

    /**
     * 分页文章数据
     *
     * @return
     */
    List<ArticleWithBLOBs> selectPage(PageForm form);

}