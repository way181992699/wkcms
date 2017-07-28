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

public class ClientIdentificationFilter extends AuthenticationFilter {
    Logger logger = Logger.getLogger(this.getClass());
    private static final String HEAD_USER_AGENT = "User-Agent";
    private static final String PARAM_USER_AGENT = "userAgent";
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        logger.info("============================= ClientIdentificationFilter init ==========================");
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        logger.info("============================= ClientIdentificationFilter doFilter ==========================");
//        String userAgent = getUserAgent((HttpServletRequest) request);
//        logger.info("userAgent ============ " + userAgent);
//        logger.info("isMobileDevices ============ " + Config.isMobileDevices(userAgent));
//
//        //移动端登录
//        if (Config.isMobileDevices(userAgent)) {
//            //获取登录用户
//
//
//        }
//        //pc端登录
//        else {
//            //判断登录用户
//            ((HttpServletRequest) request).getSession().getId();
//
//            AuthenticatingFilter filter;
//            AuthenticationFilter filter1;
//        }
//
//        //chain.doFilter(request,response);
//
//
//    }
//
//    @Override
//    public void destroy() {
//        logger.info("============================= ClientIdentificationFilter destroy ==========================");
//
//    }

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


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        logger.info("isAccessAllowed =================== " + super.isAccessAllowed(request,response,mappedValue));

        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        logger.info("====================== onAccessDenied ================== ");
        return false;
    }

    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        logger.info("====================== issueSuccessRedirect ================== ");
        super.issueSuccessRedirect(request, response);
    }
}
