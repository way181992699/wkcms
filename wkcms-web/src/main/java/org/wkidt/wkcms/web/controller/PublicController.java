package org.wkidt.wkcms.web.controller;
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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wkidt.wkcms.common.BaseController;
import org.wkidt.wkcms.common.Page;
import org.wkidt.wkcms.common.PageResult;
import org.wkidt.wkcms.common.Result;
import org.wkidt.wkcms.user.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * <p>
 * Created by zcm on 2017/7/27. version 1.0
 */
@Controller
@RequestMapping("/public")
public class PublicController extends BaseController<User> {

    /**
     * 未登录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/unlogin")
    Result unlogin() {
        return new Result(Result.STATUS_UNLOGIN, Result.MESSAGE_UNLOGIN);
    }

    /**
     * 未授权
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("unauth")
    Result unauthorized() {
        return new Result(Result.STATUS_UNAUTH, Result.MESSAGE_UNAUTH);
    }


    /**
     * 测试
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/test")
    Object test() {
        Page<?> page = new Page<>();
        page.setCurrentPage(1);
        page.setPageCount(10);
        page.setTota(1000);
        page.setData(null);
        logger.info("UserAgent ================= " + getUserAgent());

        return new PageResult<>(Result.STATUS_SUCCESS, Result.MESSAGE_SUCCESS, page);
    }


}
