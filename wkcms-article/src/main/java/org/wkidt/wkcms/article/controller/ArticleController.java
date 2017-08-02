package org.wkidt.wkcms.article.controller;
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
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wkidt.wkcms.article.form.ArticleForm;
import org.wkidt.wkcms.article.model.ArticleWithBLOBs;
import org.wkidt.wkcms.article.service.ArticleService;
import org.wkidt.wkcms.common.*;
import org.wkidt.wkcms.user.model.User;

/**
 * Description
 * <p>
 * Created by zcm on 2017/8/2. version 1.0
 */
@Controller
public class ArticleController extends BaseController<User> {
    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping(value = "/article/add", method = RequestMethod.POST)
    Result articleAdd(ArticleWithBLOBs article) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PageResult<>(Result.STATUS_UNKNOW, Result.MESSAGE_UNKNOW);
    }

    @ResponseBody
    @RequestMapping("")
    Result articleModify(){

        return null;
    }


    @ResponseBody
    @RequestMapping("/article/remove")
    Result articleRemove(Long id){


        return null;
    }



    /**
     * 获取分页文章
     *
     * @param pageForm
     * @return
     */
    @RequestMapping("/article/page")
    @ResponseBody
    PageResult<ArticleForm> articlePage(PageForm pageForm) {
        try {
            Page<ArticleForm> page = articleService.articlePage(pageForm);
            if (page.isEmpty()) {
                return new PageResult<>(Result.STATUS_NODATA, Result.MESSAGE_NODATA);
            }
            return new PageResult<>(Result.STATUS_SUCCESS, Result.MESSAGE_SUCCESS, page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PageResult<>(Result.STATUS_UNKNOW, Result.MESSAGE_UNKNOW);
    }

}
