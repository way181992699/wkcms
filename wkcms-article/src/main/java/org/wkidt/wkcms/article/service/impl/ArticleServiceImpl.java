package org.wkidt.wkcms.article.service.impl;
//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wkidt.wkcms.article.form.ArticleForm;
import org.wkidt.wkcms.article.mapper.ArticleMapper;
import org.wkidt.wkcms.article.mapper.DocCatagoryMapper;
import org.wkidt.wkcms.article.mapper.DocModelMapper;
import org.wkidt.wkcms.article.model.ArticleWithBLOBs;
import org.wkidt.wkcms.article.model.DocCatagory;
import org.wkidt.wkcms.article.model.DocModel;
import org.wkidt.wkcms.article.service.ArticleService;
import org.wkidt.wkcms.common.AbstractService;
import org.wkidt.wkcms.common.model.Page;
import org.wkidt.wkcms.common.form.PageForm;
import org.wkidt.wkcms.common.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容服务
 * <p>
 * Created by zcm on 2017/8/2. version 1.0
 */
@Service
public class ArticleServiceImpl extends AbstractService implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private DocModelMapper docModelMapper;
    @Autowired
    private DocCatagoryMapper docCatagoryMapper;


    @Override
    public Result<DocModel> getArticleModels() {
        return null;
    }

    @Override
    public Result<DocCatagory> getArticleCatagories() {
        return null;
    }


    @Override
    public boolean articleAdd(ArticleForm form) {
        //articleMapper.insertSelective(form);
        logger.info(form.getDocument() + form.getTitle() + form.getSubtitle());
        Gson gson = new Gson();
        String jsonStr = gson.toJson(form);
        logger.info(jsonStr);
        ArticleWithBLOBs bloBs = gson.fromJson(jsonStr, ArticleWithBLOBs.class);
        if (bloBs == null)
            return false;
        //
        byte[] content = form.getDocument().getBytes();
        logger.info(content);
        bloBs.setContent(content);
        int result = articleMapper.insertSelective(bloBs);
        return result > 0;
    }

    @Override
    public boolean articleModify(ArticleForm form) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(form);
        ArticleWithBLOBs bloBs = gson.fromJson(jsonStr, ArticleWithBLOBs.class);
        //
        int result = articleMapper.updateByPrimaryKeyWithBLOBs(bloBs);
        return result > 0;
    }

    @Override
    public boolean articleRemove(long id) {
        int result = articleMapper.deleteByPrimaryKey(id);
        return result > 0;
    }


    /**
     * @param pageForm
     * @return
     */

    @Override
    public Page<ArticleForm> articlePage(PageForm pageForm) {
        List<ArticleForm> articleForms = new ArrayList<>();
        List<ArticleWithBLOBs> list = articleMapper.selectPage(pageForm);
        long count = articleMapper.getCount();
        for (ArticleWithBLOBs article : list) {
            ArticleForm form = new ArticleForm();
            form.setDocument(new String(article.getContent()));
            form.setUid(article.getUid());
            articleForms.add(form);
        }
        return new Page<ArticleForm>(pageForm.getCurrentPage(), pageForm.getPageCount(), count, articleForms);
    }
}
