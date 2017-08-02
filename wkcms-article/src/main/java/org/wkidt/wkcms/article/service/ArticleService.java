package org.wkidt.wkcms.article.service;
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

import org.wkidt.wkcms.article.form.ArticleForm;
import org.wkidt.wkcms.common.Page;
import org.wkidt.wkcms.common.PageForm;

/**
 * Description
 * <p>
 * Created by zcm on 2017/8/2. version 1.0
 */

public interface ArticleService {

    /**
     * 添加文章
     *
     * @param form
     * @return
     */
    boolean articleAdd(ArticleForm form);

    /**
     * 修改文章
     *
     * @param form
     * @return
     */
    boolean articleModify(ArticleForm form);

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    boolean articleRemove(long id);

    /**
     * 分页查询文章
     *
     * @param form
     * @return
     */
    Page<ArticleForm> articlePage(PageForm form);


}
