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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wkidt.wkcms.article.form.ArticleForm;
import org.wkidt.wkcms.article.mapper.ArticleMapper;
import org.wkidt.wkcms.article.model.ArticleWithBLOBs;
import org.wkidt.wkcms.article.service.ArticleService;
import org.wkidt.wkcms.common.AbstractService;
import org.wkidt.wkcms.common.Page;
import org.wkidt.wkcms.common.PageForm;

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


    @Override
    public boolean articleAdd(ArticleForm form) {
        return false;
    }

    @Override
    public boolean articleModify(ArticleForm form) {


        return false;
    }

    @Override
    public boolean articleRemove(long id) {

        return false;
    }

    @Override
    public Page<ArticleForm> articlePage(PageForm pageForm) {
        List<ArticleForm> articleForms = new ArrayList<>();
        List<ArticleWithBLOBs> list = articleMapper.selectPage(pageForm);
        long count = articleMapper.getCount();
        for (ArticleWithBLOBs article : list) {
            ArticleForm form = new ArticleForm();
            form.setContent(new String(article.getContent()));
            form.setUid(article.getUid());
            articleForms.add(form);
        }
        return new Page<ArticleForm>(pageForm.getCurrentPage(), pageForm.getPageCount(), count, articleForms);
    }
}
