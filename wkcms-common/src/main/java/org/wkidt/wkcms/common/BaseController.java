package org.wkidt.wkcms.common;//
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.wkidt.wkcms.conf.Config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 基类控制器
 * <p>
 * Created by zcm on 2017/7/15. version 1.0
 *
 * @param <E>
 */

public abstract class BaseController<E> {
    protected Logger logger = Logger.getLogger(this.getClass());

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void initRequest(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession(true);
    }

    /**
     * 保存登录用户到session
     *
     * @param user
     */
    protected void saveLoginUser(E user) {
        if (session == null)
            throw new NullPointerException("Session is null ");
        session.setAttribute(Config.USER_KEY, user);
    }

    /**
     * 获取登录用户
     *
     * @return
     */
    protected E getLoginUser() throws IllegalAccessException, InstantiationException {
        if (session == null)
            throw new NullPointerException("Session is null");
        Object loginUser = session.getAttribute(Config.USER_KEY);
        if (loginUser != null) {
            return (E) loginUser;
        }
        return null;
    }

    /**
     * 删除登录用户
     */
    protected void removeLoginUser() {
        if (session == null)
            throw new NullPointerException("Session is null");
        session.removeAttribute(Config.USER_KEY);
    }

    /**
     * 图片验证码
     *
     * @return
     */
    protected String getVerifyCode() {
        return (String) session.getAttribute(Config.CODE_VERIFY);
    }

    /* ***************************************************************************************** */
    /* ***************************************************************************************** */
    /* *** 客户端识别，优先从参数userAgent中获取客户端标识，若参数中拿不到再从请求头User-Agent中获取 **** */
    /* ***************************************************************************************** */
    /* ***************************************************************************************** */

    private static final String HEAD_USER_AGENT = "User-Agent";
    private static final String PARAM_USER_AGENT = "userAgent";

    /**
     * 获取客户端识别
     *
     * @return
     */
    protected String getUserAgent() {
        String userAgent;
        userAgent = request.getParameter(PARAM_USER_AGENT);
        if (userAgent == null) {
            userAgent = request.getHeader(HEAD_USER_AGENT);
        }
        return userAgent;
    }

    /**
     * andorid设备
     *
     * @return
     */
    protected boolean isAndroidDevice() {
        if (getUserAgent() == null)
            return false;
        return false;
    }

    /**
     * IOS设备
     *
     * @return
     */
    protected boolean isIosDevices() {
        if (getUserAgent() == null)
            return false;
        return false;
    }

    /**
     * PC端设备
     *
     * @return
     */
    protected boolean isPcDevice() {
        if (getUserAgent() == null)
            return false;
        return false;
    }

    /**
     * 移动端设备
     *
     * @return
     */
    protected boolean isMobileDevice() {
        if (getUserAgent() == null)
            return false;
        return false;
    }


}
