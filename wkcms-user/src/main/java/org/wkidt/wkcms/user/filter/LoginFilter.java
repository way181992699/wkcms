package org.wkidt.wkcms.user.filter;
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
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.wkidt.wkcms.conf.Config;
import org.wkidt.wkcms.user.model.User;
import org.wkidt.wkcms.utils.ChacheUtils;
import org.wkidt.wkcms.utils.RequestUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证
 * <p>
 * Created by zcm on 2017/7/28. version 1.0
 */

public class LoginFilter extends FormAuthenticationFilter {
    Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //判断客户端
        if (RequestUtils.isMobileDevice((HttpServletRequest) request)) {
            //查询手机端是否登录 缓存 redis
            String acct = RequestUtils.getAccentToken((HttpServletRequest) request);
            User user = (User) ChacheUtils.getInstance().get(acct);
            if (user != null) {
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
                getSubject(request, response).login(token);
                if (getSubject(request, response).isAuthenticated()) {
                    return true;
                }
            }
            //验证失败跳转登录界面
            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
        //查询web端是否登录 session
        return super.onAccessDenied(request, response);
    }
}
