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

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wkidt.wkcms.common.BaseController;
import org.wkidt.wkcms.common.Result;
import org.wkidt.wkcms.user.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 首页控制器
 * <p>
 * Created by zcm on 2017/7/20. version 1.0
 */
@Controller
public class IndexController extends BaseController<User> {

    @RequestMapping("/")
    @ResponseBody
    Result index() {
        logger.info("======================== index ======================= ");
        return new Result(Result.STATUS_SUCCESS, "Index page");
    }

}
