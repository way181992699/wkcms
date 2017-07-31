package org.wkidt.wkcms.web.filter;
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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.wkidt.wkcms.conf.Config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 客户端识别
 * <p>
 * Created by zcm on 2017/7/28. version 1.0
 */

public class LoginFilter extends AccessControlFilter {
    Logger logger = Logger.getLogger(this.getClass());
    private static final String HEAD_USER_AGENT = "User-Agent";
    private static final String PARAM_USER_AGENT = "userAgent";


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        logger.info(getUserAgent((HttpServletRequest) request));
        //判断客户端
        if (Config.isMobileDevices(getUserAgent((HttpServletRequest) request))) {
            //查询手机端是否登录 缓存 redis

        } else {
            //查询web端是否登录 session
           return SecurityUtils.getSubject().isAuthenticated();

        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return false;
    }

    /**
     * 获取客户端识别
     *
     * @param request
     * @return
     */
    private String getUserAgent(HttpServletRequest request) {
        String userAgent;
        userAgent = request.getParameter(PARAM_USER_AGENT);
        if (userAgent == null) {
            userAgent = request.getHeader(HEAD_USER_AGENT);
        }
        return userAgent;
    }

}
